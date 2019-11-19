package cn.ekgc.dkscm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.UserDao;
import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.service.UserService;

/**
 * <b>用户业务层接口实现类</b>
 * @author Administrator
 * @version 1.0 2019.11.13
 * @since 2019.11.13
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	private UserDao userDao;

	/**
	 * <b>根据用户手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	public User getUserByCellphone(String cellphone) throws Exception {
		// 封装查询参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cellphone", cellphone);
		// 得到查询结果集
		List<User> userList = userDao.findUserByQuery(paramMap);
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}
}
