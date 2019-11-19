package cn.ekgc.dkscm.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>订单实体类</b>
 * @author Administrator
 * @version 1.0 2019.11.12
 * @since 2019.11.12
 */
public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long  purchaseId;								// 采购主键
	private String purchaseNo;								// 采购编码
	private String goodsName;								// 物资名称
	private String goodsType;								// 物资型号
	private Double applyQuantity;							// 物资数量
	private String goodsUnit;								// 物资单位
	private Double budget;								    // 采购预算
	private String applyRemark;								// 申请备注
	private User applicant;									// 申请人
	private Date applyTime;									// 申请时间
	private User reviewer;									// 申请审批人
	private String reviewRemark;                            // 申请审批意见
	private Date reviewTime;                                // 审核时间
	private User purchaser;									// 采购人
	private String purchaseBand;							// 采购品牌
	private String purchaseType;                            // 采购型号
	private Double purchaseQuantity;                        // 采购数量
	private Double purchaseAmount;							// 采购金额
	private String purchaseRemark;                          // 采购备注
	private Date purchaseTime;								// 采购时间
	private User storeReviewer;								// 入库申请人
	private String storeReviewRemark;                       // 入库申请备注
	private Date storeReviewTime;                           // 入库审批时间 
	private User storeMan;									// 入库人
	private String storeRemark;                            	// 入库备注
	private Date storeTime;                               	// 入库时间
	private User receiver;									// 领取人
	private String receiveRemark;                           // 领取备注
	private Date receiveTime;                               // 领取时间
	private String statusCode;								// 状态编码
	private Date createTime;								// 创建时间
	
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public Double getApplyQuantity() {
		return applyQuantity;
	}
	public void setApplyQuantity(Double applyQuantity) {
		this.applyQuantity = applyQuantity;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public String getApplyRemark() {
		return applyRemark;
	}
	public void setApplyRemark(String applyRemark) {
		this.applyRemark = applyRemark;
	}
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public User getReviewer() {
		return reviewer;
	}
	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
	public String getReviewRemark() {
		return reviewRemark;
	}
	public void setReviewRemark(String reviewRemark) {
		this.reviewRemark = reviewRemark;
	}
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	public User getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(User purchaser) {
		this.purchaser = purchaser;
	}
	public String getPurchaseBand() {
		return purchaseBand;
	}
	public void setPurchaseBand(String purchaseBand) {
		this.purchaseBand = purchaseBand;
	}
	public String getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	public Double getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Double purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public String getPurchaseRemark() {
		return purchaseRemark;
	}
	public void setPurchaseRemark(String purchaseRemark) {
		this.purchaseRemark = purchaseRemark;
	}
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public User getStoreReviewer() {
		return storeReviewer;
	}
	public void setStoreReviewer(User storeReviewer) {
		this.storeReviewer = storeReviewer;
	}
	public String getStoreReviewRemark() {
		return storeReviewRemark;
	}
	public void setStoreReviewRemark(String storeReviewRemark) {
		this.storeReviewRemark = storeReviewRemark;
	}
	public Date getStoreReviewTime() {
		return storeReviewTime;
	}
	public void setStoreReviewTime(Date storeReviewTime) {
		this.storeReviewTime = storeReviewTime;
	}
	public User getStoreMan() {
		return storeMan;
	}
	public void setStoreMan(User storeMan) {
		this.storeMan = storeMan;
	}
	public String getStoreRemark() {
		return storeRemark;
	}
	public void setStoreRemark(String storeRemark) {
		this.storeRemark = storeRemark;
	}
	public Date getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public String getReceiveRemark() {
		return receiveRemark;
	}
	public void setReceiveRemark(String receiveRemark) {
		this.receiveRemark = receiveRemark;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
