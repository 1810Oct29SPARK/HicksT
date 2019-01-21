package com.revature.service;

import org.springframework.stereotype.Service;

@Service
public class BearService extends AnimalService {

	public Boolean bearFull = true;
	private static Boolean isWinter = true;
	
	public Boolean getBearFull() {
		return bearFull;
	}

	public void setBearFull(Boolean bearFull) {
		this.bearFull = bearFull;
	}

	public static Boolean getIsWinter() {
		return isWinter;
	}

	public static void setIsWinter(Boolean isWinter) {
		BearService.isWinter = isWinter;
	}

	public BearService() {
	
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean isFull() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFull(Boolean full) {
		// TODO Auto-generated method stub

	}

	@Override
	public void animalChasesYou() {
		System.out.println("Bear is Chasing You!");
	}

}
