package com.mrfz.bean;
public class ResultBean<T> {
	
	
	/**
	 * 状态信息: 是否成功
	 */
	boolean isSuccess;
	
	/**
	 * 说明信息
	 */
	String message;
	
	/**
	 * 状态数据
	 */
	T data;
	

	/**
	 * 构造函数
	 */
	public ResultBean(){}
	
	/**
	 * 带参数构造函数
	 * @param isSuccess 
	 * @param message
	 * @param data
	 */
	public ResultBean(boolean isSuccess, String message, T data){ this.isSuccess = isSuccess;
		this.message = message;
		this.data = data;
	}
	
	public boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "isSuccess:" + isSuccess + ",message:" + message + ",data:" + data;
	}
}
