package com.company.sutrix.model;

import java.util.Date;

public class ErrorMessage {
	private Date date;
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private String error;
	private String message;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ErrorMessage(Date date, int status,String error, String message) {
		super();
		this.date = date;
		this.status = status;
		this.error = error;
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
