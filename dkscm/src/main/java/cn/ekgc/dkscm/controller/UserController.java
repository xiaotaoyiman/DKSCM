package cn.ekgc.dkscm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ekgc.dkscm.controller.base.BaseController;
import cn.ekgc.dkscm.service.UserService;

/**
 * <b>用户模块控制器</b>
 * @author Administrator
 * @version 1.0 2019.11.12
 * @since 2019.11.12
 */
@Controller("userContoller")
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource(name = "userService")
	private UserService userService;
	
	/**
	 * <b>转发至登录界面</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() throws Exception{
		return "user/login_form";	
	}
	
	/**
	 * <b>进行用户登录</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() throws Exception{
		// 如果一旦集成了Shiro的安全认证机制，那么此时的post请求，
		// 将会变为当Shiro认证失败之后所调用的请求
		// 如果登陆失败，则可以进行退出操作
		return "redirect:logout";	
	}
}
