package cn.ekgc.dkscm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.MenuDao;
import cn.ekgc.dkscm.pojo.entity.Menu;
import cn.ekgc.dkscm.pojo.entity.Role;
import cn.ekgc.dkscm.service.MenuService;
import cn.ekgc.dkscm.util.ConstantUtil;

/**
 * <b>菜单业务层接口实现类</b>
 * @author Administrator
 * @version 1.0 2019.11.14
 * @since 2019.11.14
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	@Resource(name = "menuDao")
	private MenuDao menuDao;
	/**
	 * <b>根据条件查询菜单列表信息</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public List<Menu> getMenuList(Role role) throws Exception {
		// 封装查询参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 查询一级菜单
		paramMap.put("roleId", role.getRoleId());
		paramMap.put("parentId", 0L);
		paramMap.put("statusCode", ConstantUtil.STATUS_ENABLE);
		// 获得查询结果集
		List<Menu> menuList = menuDao.findMenuByQuery(paramMap);
		// 判断一级菜单是否有值，如果存在，则遍历一级菜单，获得其二级菜单
		if (menuList != null && menuList.size() > 0) {
			// 遍历一级菜单
			for (Menu parent : menuList) {
				// 将一级菜单的主键作为二级菜单的上级主键
				paramMap.put("parentId", parent.getMenuId());
				// 查询二级菜单，获得查询结果集
				List<Menu> childList = menuDao.findMenuByQuery(paramMap);
				// 将查询的二级菜单列表放入一级菜单对象中
				parent.setChildList(childList);
			}
		}
		return menuList;
	}

}
