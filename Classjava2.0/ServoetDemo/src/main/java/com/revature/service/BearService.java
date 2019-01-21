package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;

public class BearService {

	private ObjectMapper om = new ObjectMapper();
	
	public String getBearsJSON() {
		List<Bear> bearList = new ArrayList<>();
		bearList.add(new Bear(4, "Bertha", new Cave(7, "Cave1", 4), new BearType(3, "Grizzly"), 400, null));
		bearList.add(new Bear(6, "Fred", new Cave(7, "Cave1", 4), new BearType(3, "Grizzly"), 402, null));
		String bearString = "";
		try {
			bearString = om.writeValueAsString(bearList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return bearString;
	}

}
