package cn.ekgc.dkscm.service;

import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.vo.Page;

/**
 * <b>采购业务层接口</b>
 * @author Administrator
 * @version 1.0 2019.11.18
 * @since 2019.11.18
 */
public interface PurchaseService {
	
	/**
	 * <b>根据条件分页查询采购订单</b>
	 * @param statusCode
	 * @param page
	 * @return
	 */
	Page<Purchase> getPurchaseListByPage(String statusCode, Page<Purchase> page) throws Exception;

}
