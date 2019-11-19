package cn.ekgc.dkscm.pojo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <b>菜单实体类</b>
 * @author Administrator
 * @version 1.0 2019.11.12
 * @since 2019.11.12
 */
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long menuId; 								// 菜单主键
	private Menu parentMenu;                            // 上级菜单
	private String menuText;							// 菜单文本
	private String menuUrl;								// 链接地址
	private String menuIcon;							// 图标
	private Integer sortOrder;							// 排序
	private List<Menu> childList;						// 下级菜单
	private List<Role> roleList;                        // 角色列表
	private Status status;								// 状态
	private Date createTime;							// 创建时间
	private Date updateTime;							// 修改时间
	
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public String getMenuText() {
		return menuText;
	}
	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public List<Menu> getChildList() {
		return childList;
	}
	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
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
