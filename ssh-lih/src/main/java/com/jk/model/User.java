package com.jk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="c_user")
public class User implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialSVersionUID = 4969141456613613191L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	
	private String userName;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userTime;
	
	private Integer userAge;
	
	
	private String userPassword;
	
	
	private Integer typeId;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Date getUserTime() {
		return userTime;
	}


	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}


	public Integer getUserAge() {
		return userAge;
	}


	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public Integer getTypeId() {
		return typeId;
	}


	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userTime=" + userTime + ", userAge=" + userAge
				+ ", userPassword=" + userPassword + ", typeId=" + typeId + "]";
	}


	
	
	
	
	
	

}
