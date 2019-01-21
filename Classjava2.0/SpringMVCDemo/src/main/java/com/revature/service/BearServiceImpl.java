package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Bear;
import com.revature.dao.BearDAO;
import com.revature.dao.FakeBearDAOImpl;

@Service(value="bearService")
public class BearServiceImpl implements BearService {
	
	private BearDAO bd = new FakeBearDAOImpl();

	public BearServiceImpl() {
	}

	public List<Bear> allBears() {
		return bd.allBears();
	}

	public Bear getBearById(int id) {
		return bd.getBearById(id);
	}

	public void createBear(Bear bear) {
		bd.createBear(bear);
	}

	public Bear updateBear(Bear bear) {
		return bd.updateBear(bear);
	}

	public void deleteBear(Bear bear) {
		bd.deleteBear(bear);
	}

	
}
