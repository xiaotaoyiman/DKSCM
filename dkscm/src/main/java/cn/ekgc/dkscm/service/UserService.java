package cn.ekgc.dkscm.service;

import cn.ekgc.dkscm.pojo.entity.User;

/**
 * <b>用户业务层接口</b>
 * @author Administrator
 * @version 1.0 2019.11.13
 * @since 2019.11.13
 */
public interface UserService {
	/**
	 * <b>根据用户手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	 User getUserByCellphone(String cellphone) throws Exception;

}
