package com.revature.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;

public class FakeBearDAOImpl implements BearDAO {
	
	private List<Bear> myBears = new ArrayList<Bear>();
	
	public FakeBearDAOImpl() {
		Cave c1 = new Cave(3, "Tampa", 5);
		BearType bt = new BearType(7,"Grizzly");
		BearType bt2  = new BearType(9,"Polar");
		myBears.add(new Bear(5, "Susan", c1, bt2, 600, LocalDate.of(2000, Month.APRIL, 15)));
		myBears.add(new Bear(81, "Bob", c1, bt, 650, LocalDate.of(1970, Month.NOVEMBER, 30)));
	}

	public List<Bear> allBears() {
		return myBears;
	}

	public Bear getBearById(int id) {
		Bear toReturn = null;
		for (Bear b : myBears) {
			if (b.getId() == id) {
				toReturn  = b;
			}
		}
		return toReturn;
	}

	public void createBear(Bear bear) {
		myBears.add(bear);
	}

	public Bear updateBear(Bear bear) {
		for (Bear b : myBears) {
			if (b.getId() == bear.getId()) {
				b.setName(bear.getName());
				b.setCave(bear.getCave());
				b.setBearType(bear.getBearType());
				b.setWeight(bear.getWeight());
				b.setBirthdate(bear.getBirthdate());
				return b;
			}
		}
		return null;
	}

	public void deleteBear(Bear bear) {
		//use iterator to remove in-place!!! 
		Iterator<Bear> it = myBears.iterator();
		while(it.hasNext()){
			Bear b = it.next();
			if (b.getId() == bear.getId()) {
				it.remove();
			}
		}
	}

}
