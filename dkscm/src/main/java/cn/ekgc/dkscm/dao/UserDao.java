package cn.ekgc.dkscm.dao;

import java.util.List;
import java.util.Map;

import cn.ekgc.dkscm.pojo.entity.User;
/**
 * <b>用户数据持久层接口</b>
 * @author Administrator
 * @version 1.0 2019.11.13
 * @since 2019.11.13
 */
public interface UserDao {
	/**
	 * <b>根据条件查询用户信息列表</b>
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<User> findUserByQuery(Map<String, Object> paramMap) throws Exception;

}
