package com.gillsoft.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Log {
	
	private LogType type;
	
	private long id;
	
	private int code;
	
	private String description;
	
	private String message;
	
	private String stackTrace;
	
	private String body;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-dd-MM'T'HH:mm:ss.SSSXXX")
	private Date time;
	
	private String owner;

	public LogType getType() {
		return type;
	}

	public void setType(LogType type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Log [type=" + type + ", id=" + id + ", code=" + code
				+ ", description=" + description + ", message=" + message
				+ ", stackTrace=" + stackTrace + ", body=" + body + ", time="
				+ time + ", owner=" + owner + "]";
	}

}
