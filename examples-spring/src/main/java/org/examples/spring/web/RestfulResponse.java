package org.examples.spring.web;

import java.io.Serializable;

public class RestfulResponse implements Serializable {

	private static final long serialVersionUID = -5795089018013798231L;

	private boolean success;

	private String code;

	private String msg;

	/**
	 * total recorded
	 */
	private int result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
