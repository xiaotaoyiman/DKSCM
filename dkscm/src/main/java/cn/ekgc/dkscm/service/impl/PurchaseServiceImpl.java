package cn.ekgc.dkscm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.PurchaseDao;
import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.PurchaseService;

/**
 * <b>采购业务层接口实现类</b>
 * @author Administrator
 * @version 1.0 2019.11.13
 * @since 2019.11.13
 */
@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseDao purchaseDao;

	/**
	 * <b>根据条件分页查询采购订单</b>
	 * @param statusCode
	 * @param page
	 * @return
	 */
	public Page<Purchase> getPurchaseListByPage(String statusCode, Page<Purchase> page) 
			throws Exception {
		// 设置分页查询的参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("begin", page.getBegin());
		paramMap.put("size", page.getPageSize());
		paramMap.put("statusCode", statusCode);
		List<Purchase> list = purchaseDao.findPurchaseListByPage(paramMap);
		// 删除Map集合中的分页信息，获得总条数
		paramMap.remove("begin");
		paramMap.remove("size");
		Long totalSize = (long)(purchaseDao.findPurchaseListByPage(paramMap)).size();
		Long totalPage = page.getTotalPage();
		page.setList(list);
		page.setTotalSize(totalSize);
		page.setTotalPage(totalPage);
		return page;
	}
}
