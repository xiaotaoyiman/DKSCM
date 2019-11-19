package cn.ekgc.dkscm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ekgc.dkscm.controller.base.BaseController;
import cn.ekgc.dkscm.pojo.entity.Menu;
import cn.ekgc.dkscm.pojo.entity.Role;
import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.service.MenuService;

/**
 * <b>系统首页面控制器</b>
 * @author Administrator
 * @version 1.0 2019.11.12
 * @since 2019.11.12
 */
@Controller("indexController")
public class IndexController extends BaseController {
	@Resource(name = "menuService")
	private MenuService menuService;
	
	/**
	 * <b>加载系统首界面</b>
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap modelMap) throws Exception {
		// 获得当前登录用户信息
		User user = (User) session.getAttribute("user");
		// 根据当前登录用户获得用户角色信息
		Role role = user.getRole();
		// 根据角色获得对应的菜单列表
		List<Menu> menuList = menuService.getMenuList(role);
		// 将结果绑定到集合中，进行转发
		modelMap.put("menuList", menuList);
		// 转发到首界面
		return "index";
	}
}
