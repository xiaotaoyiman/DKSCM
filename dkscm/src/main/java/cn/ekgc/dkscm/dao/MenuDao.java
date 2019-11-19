package cn.ekgc.dkscm.dao;

import java.util.List;
import java.util.Map;

import cn.ekgc.dkscm.pojo.entity.Menu;

/**
 * <b>菜单数据持久层接口</b>
 * @author Administrator
 * @version 1.0 2019.11.14
 * @since 2019.11.14
 */
public interface MenuDao {
	
	/**
	 * <b>根据查询条件查询菜单列表</b>
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<Menu> findMenuByQuery(Map<String, Object> paramMap) throws Exception;

}
