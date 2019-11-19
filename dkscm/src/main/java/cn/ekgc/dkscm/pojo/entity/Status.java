package cn.ekgc.dkscm.pojo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <b>状态实体类</b>
 * @author Administrator
 * @version 1.0 2019.11.12
 * @since 2019.11.12
 */
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long statusId;                              // 状态主键
	private String statusText;							// 状态文本
	private String statusCode;							// 状态编码
	private Date createTime;							// 创建时间
	private Date updateTime;							// 修改时间
	
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
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
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
