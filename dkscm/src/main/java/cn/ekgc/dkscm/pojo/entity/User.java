package cn.ekgc.dkscm.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>用户实体类</b>
 * @author Administrator
 * @version 1.0 2019.11.12
 * @since 2019.11.12
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;								// 用户主键
	private String userNo;								// 用户编码
	private String username;							// 用户姓名
	private String cellphone;							// 手机号码
	private String password;							// 登录密码
	private Role role;                                  // 角色信息
	private String idCard;								// 身份证号码
	private String email;								// 电子邮箱
	private String userPhoto;							// 头像
	private Status status;								// 状态
	private Date createTime;							// 创建时间
	private Date updateTime;							// 修改时间
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
