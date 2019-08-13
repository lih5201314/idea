package com.jk.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Permission  implements Serializable{
    private Integer id;

    private String name;

    private Integer pid;

    private String text;

    private String url;

    private String state;

    private String description;

    private String checked;

    private List<Permission> children;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
    }

	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}

	public void setAttributes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}
    
}