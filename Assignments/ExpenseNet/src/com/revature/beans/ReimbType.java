package com.revature.beans;

public class ReimbType {

	public int typeId;
	public String typeName;
	
	@Override
	public String toString() {
		return "ReimbStatus [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	public ReimbType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public ReimbType(int typeId) {
		super();
		this.typeId = typeId;
	}
	
	
	
}
