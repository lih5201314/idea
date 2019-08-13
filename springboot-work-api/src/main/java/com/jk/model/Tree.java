package com.jk.model;

import java.io.Serializable;
import java.util.List;

public class Tree  implements Serializable {
	private Integer id  ;
	private String text  ;
	private Integer pid ;
	private String url ;
	
	//�첽��״̬�ֶ�
	private String state;
	
	/**
	 * �ӽڵ㼯��    һ���ڵ��������������ɽڵ㡣
	 */
	private List<Tree> children;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	
}
