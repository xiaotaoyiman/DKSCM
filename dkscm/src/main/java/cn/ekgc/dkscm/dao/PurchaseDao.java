package cn.ekgc.dkscm.dao;

import java.util.List;
import java.util.Map;

import cn.ekgc.dkscm.pojo.entity.Purchase;

/**
 * <b>采购数据持久层接口</b>
 * @author Administrator
 * @version 1.0 2019.11.14
 * @since 2019.11.14
 */
public interface PurchaseDao {
	
	/**
	 * <b>根据查询条件查询采购列表</b>
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<Purchase> findPurchaseListByPage(Map<String, Object> paramMap);

}
