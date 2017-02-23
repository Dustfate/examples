package org.examples.spring.entity.menu;

import java.util.Date;
import java.util.List;

import com.dexcoder.commons.pager.Pageable;

/**
 * 系统菜单
 * @author Dusf
 *
 */
public class SysMenuInfo extends Pageable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String menuId;
	private String menuName;	//菜单名称
	private String parentId;	//父ID
	private String menuUrl;		//菜单链接
	private int menuOrder;		//排序
	private String menuIcon;	//菜单图标
	private int menuType;		//菜单类型
	private String isEnable;	//是否可用
	private Date createTime;	//创建时间
	private Date updateTime;	//更新时间
	
	private SysMenuInfo parentMenu;
	private boolean hasMenu = false;
	private List<SysMenuInfo> subMenu;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public int getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public int getMenuType() {
		return menuType;
	}
	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}
	public String getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
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
	public SysMenuInfo getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(SysMenuInfo parentMenu) {
		this.parentMenu = parentMenu;
	}
	public boolean isHasMenu() {
		return hasMenu;
	}
	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}
	public List<SysMenuInfo> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<SysMenuInfo> subMenu) {
		this.subMenu = subMenu;
	}
	
}