package com.jk.model;

import java.io.Serializable;
import java.util.Date;

/*import org.springframework.data.mongodb.core.mapping.Document;*/
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/*@Document(collection="t_log")*/
public class LogModel  implements Serializable {
	private String id;
	private String logname;
	private String logip;
	private String logis;
	private String parame;
	private String requerpath;
	
	   private String userId;
	 
	   private Object returningValue;
	   
	 @DateTimeFormat(pattern = "yyyy-MM-dd") // �����	ǰ�˵���˵�ʱ��
	 @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// �����	��˵�ǰ�˵�ʱ��
	private Date logtime;
	 @DateTimeFormat(pattern = "yyyy-MM-dd") // �����	ǰ�˵���˵�ʱ��
	 @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// �����	��˵�ǰ�˵�ʱ��
	private Date starDate;
	 @DateTimeFormat(pattern = "yyyy-MM-dd") // �����	ǰ�˵���˵�ʱ��
	 @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// �����	��˵�ǰ�˵�ʱ��
	private Date endDate;
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getLogip() {
		return logip;
	}
	public void setLogip(String logip) {
		this.logip = logip;
	}
	public String getLogis() {
		return logis;
	}
	public void setLogis(String logis) {
		this.logis = logis;
	}

	public Date getLogtime() {
		return logtime;
	}
	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}
	public Date getStarDate() {
		return starDate;
	}
	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getParame() {
		return parame;
	}
	public void setParame(String parame) {
		this.parame = parame;
	}
	public String getRequerpath() {
		return requerpath;
	}
	public void setRequerpath(String requerpath) {
		this.requerpath = requerpath;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Object getReturningValue() {
		return returningValue;
	}
	public void setReturningValue(Object returningValue) {
		this.returningValue = returningValue;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
