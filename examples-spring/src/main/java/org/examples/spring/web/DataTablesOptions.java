package org.examples.spring.web;

import java.util.List;

/**
 * jQuery.datatables的服务器请求方式的映射实体类
 * @author Dusf
 *
 * @param <T>
 */
public class DataTablesOptions<T> {

	/**
	 * 必要。上面提到了，Datatables发送的draw是多少那么服务器就返回多少。
	 * 这里注意，作者出于安全的考虑，强烈要求把这个转换为整形，即数字后再返回， 而不是纯粹的接受然后返回，这是 为了防止跨站脚本（XSS）攻击。
	 */
	private int draw;

	/**
	 * 必要。即没有过滤的记录数（数据库里总共记录数）
	 */
	private int recordsTotal;

	/**
	 * 必要。过滤后的记录数（如果有接收到前台的过滤条件，则返回的是过滤后的记录数）
	 */
	private int recordsFiltered;

	/**
	 * 起始页码
	 */
	private int start;
	
	/**
	 * 页面显示条数
	 */
	private int length;
	
	/**
	 * 当前页码
	 */
	private int pageNumber;
	
	/**
	 * 必要。表中中需要显示的数据。 这是一个对象数组，也可以只是数组，区别在于纯数组前台就不需要用 columns绑定数据，会自动按照顺序去显示 ，
	 * 而对象数组则需要使用 columns绑定数据才能正常显示。 注意这个 data的名称可以由 ajaxOption ajax的
	 * ajax.dataSrcOption columns.dataSrc 1不定时一讲 columns.dataSrc 2不定时一讲 控制
	 */
	private List<T> data;

	/**
	 * 可选。你可以定义一个错误来描述服务器出了问题后的友好提示
	 */
	private String error;

	/**
	 * 自动绑定到 tr节点上
	 */
	private String DT_RowId;

	/**
	 * 自动把这个类名添加到 tr
	 */
	private String DT_RowClass;

	/**
	 * 使用 jQuery.data()方法把数据绑定到row中，方便之后用来检索（比如加入一个点击事件）
	 */
	private Object DT_RowData;

	/**
	 * 自动绑定数据到 tr上，使用 jQuery.attr() 方法，对象的键用作属性，值用作属性的值。 注意这个 需要 Datatables
	 * 1.10.5+的版本才支持
	 */
	private Object DT_RowAttr;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getPageNumber() {
		if(start == 0)
			pageNumber = 1;
		else
			pageNumber = (start + length + length - 1)/length;
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDT_RowId() {
		return DT_RowId;
	}

	public void setDT_RowId(String dT_RowId) {
		DT_RowId = dT_RowId;
	}

	public String getDT_RowClass() {
		return DT_RowClass;
	}

	public void setDT_RowClass(String dT_RowClass) {
		DT_RowClass = dT_RowClass;
	}

	public Object getDT_RowData() {
		return DT_RowData;
	}

	public void setDT_RowData(Object dT_RowData) {
		DT_RowData = dT_RowData;
	}

	public Object getDT_RowAttr() {
		return DT_RowAttr;
	}

	public void setDT_RowAttr(Object dT_RowAttr) {
		DT_RowAttr = dT_RowAttr;
	}

}
