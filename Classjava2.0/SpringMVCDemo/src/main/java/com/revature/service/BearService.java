package com.revature.service;

import java.util.List;

import com.revature.beans.Bear;

public interface BearService {
	
	public List<Bear> allBears();
	public Bear getBearById(int id);
	public void createBear(Bear bear);
	public Bear updateBear(Bear bear);
	public void deleteBear(Bear bear);
}
