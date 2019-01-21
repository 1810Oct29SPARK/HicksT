package com.revature.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.util.ConnectionUtil;

public interface BearDAO {
	
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	
	public double feedBear(int bearId, int hiveId, double amt);
}
