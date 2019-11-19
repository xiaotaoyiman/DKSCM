package cn.ekgc.dkscm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ekgc.dkscm.controller.base.BaseController;
import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.PurchaseService;
import cn.ekgc.dkscm.util.ConstantUtil;

/**
 * <b>订单模块控制层</b>
 * @author Administrator
 * @version 1.0 2019.11.18
 * @since 2019.11.18
 */
@Controller("purchaseController")
@RequestMapping("/purchase")
public class PurchaseController extends BaseController {
	@Resource(name = "purchaseService")
	private PurchaseService purchaseService;
	
	@RequestMapping(value = "/{statusCode}/index")
	public String purchaseIndex(@PathVariable("statusCode") String statusCode, ModelMap map) 
			throws Exception {
		map.put("statusCode", statusCode);
		// 因为使用了异步请求，因此对于该处理，仅仅是转发到列表页面
		if (ConstantUtil.STATUS_APPLY.equals(statusCode)) {
			return "purchase/purchase_apply";
		} else if (ConstantUtil.STATUS_REVIEW.equals(statusCode)) {
			return "purchase/purchase_review";
		} else if (ConstantUtil.STATUS_PURCHASE.equals(statusCode)) {
			return "purchase/purchase_purchase";
		} else if (ConstantUtil.STATUS_REPO_REVIEW.equals(statusCode)) {
			return "purchase/purchase_repo_review";
		} else if (ConstantUtil.STATUS_REPO.equals(statusCode)) {
			return "purchase/purchase_repo";
		} else if (ConstantUtil.STATUS_RECEIVE.equals(statusCode)) {
			return "purchase/purchase_receive";
		} else if (ConstantUtil.STATUS_REVIEW_BACK.equals(statusCode)) {
			return "purchase/purchase_review_back";
		} else if (ConstantUtil.STATUS_REPO_BACK.equals(statusCode)) {
			return "purchase/purchase_repo_back";
		}
		return "";
	}
	
	@RequestMapping(value = "/{statusCode}/list")
	@ResponseBody
	public Page<Purchase> getPurchaseListByPage(@PathVariable("statusCode") String statusCode, 
			Integer pageNum, Integer pageSize, Integer draw) throws Exception {
		// 封装page对象
		Page<Purchase> page = new Page<Purchase>(pageNum, pageSize, draw);
		// 使用业务层进行查询
		page = purchaseService.getPurchaseListByPage(statusCode, page);
		return page;
		
	}
}
