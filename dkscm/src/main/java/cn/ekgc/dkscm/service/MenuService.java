package cn.ekgc.dkscm.service;

import java.util.List;

import cn.ekgc.dkscm.pojo.entity.Menu;
import cn.ekgc.dkscm.pojo.entity.Role;

/**
 * <b>菜单业务层接口</b>
 * @author Administrator
 * @version 1.0 2019.11.14
 * @since 2019.11.14
 */
public interface MenuService {
	/**
	 * <b>根据条件查询菜单列表信息</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	List<Menu> getMenuList(Role role) throws Exception;

}
