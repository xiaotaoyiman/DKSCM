package cn.ekgc.dkscm.util.shiro;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.cj.Session;

import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.service.UserService;
import cn.ekgc.dkscm.util.ConstantUtil;
import cn.ekgc.dkscm.util.MD5Util;

/**
 * <b>Shiro安全认证域，当Shiro对某个请求进行认证的时候，所要使用的规则</b>
 * @author Administrator
 * @version 1.0.0 2019-11-12
 * @since 2019-11-12
 *
 */
@Component("shiroDBRealm")
public class ShiroDBRealm extends AuthorizingRealm {
	@Resource(name = "userService")
	private UserService userService;
	@Autowired
	private HttpSession session;
	/**
	 * <b>当使用Shiro授权的时候，调用的方法</b>
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * <b>当使用Shiro用户身份验证的时候，调用的方法</b>
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		// 对于Shiro来说，该方法将会具体处理登陆过程
		// Shiro会将用户登录的所有数据封装到AuthenticationToken
		// 由于我们登录使用的是用户名密码，因此需要对AuthenticationToken进行强制类型转换
		// Shiro会调用request.getParameter("username")，request.getParameter("password");
		UsernamePasswordToken userToken = (UsernamePasswordToken) token;
		// 通过UsernamePasswordToken获得登录名和密码
		String cellphone = userToken.getUsername();
		char[] passwords = userToken.getPassword();
		// 进行校验
		if (cellphone != null && !"".equals(cellphone.trim())
				&& passwords != null && passwords.length > 0) {
			// 说明用户填写的信息有效
			// 将此时用户的密码进行加密处理
			String password = MD5Util.encrypt(new String(passwords));
			// 将加密后的密码重新设回userToken中
			userToken.setPassword(password.toCharArray());
			try {
				// 通过手机号码查询用户信息
				User user = userService.getUserByCellphone(cellphone);
				if (user != null && user.getStatus().getStatusCode().equals(ConstantUtil.STATUS_ENABLE)) {
					// 校验密码是否正确
					SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getCellphone(), user.getPassword(), getName());
					// 默认登录成功时
					session.setAttribute("user", user);
					return info;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
