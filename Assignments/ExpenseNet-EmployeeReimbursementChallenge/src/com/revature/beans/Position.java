package com.revature.beans;

public class Position {
	public int positionId;
	public String positionName;

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(int positionId, String positionName) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + "]";
	}

}
