package com.jk.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "c_user_type")
public class UserType implements Serializable {
    //搴忓垪鍖栨槸鎸囨妸瀵硅薄杞寲涓轰簩杩涘埗鐨勬祦鏁版嵁  鍙嶅簭鍒楀寲鏄寚鎶婁簩杩涘埗鐨勬祦鏁版嵁杞寲涓哄璞�
	//闈炲簭鍒楀寲瀵硅薄  Request Session Application
	/**
	 * 
	 */
	private static final long serialVersionUID = 7162201464734236916L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer typeId;
	
	private String typeName;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "UserType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
	
	

}
