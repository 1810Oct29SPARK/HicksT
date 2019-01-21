package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Bear;
import com.revature.service.BearService;

@Controller
@RequestMapping(value="/bear")
public class BearController {
	
	@Autowired
	private BearService bearService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody //returns just data
	public ResponseEntity<List<Bear>> getAllBears() {
		return new ResponseEntity<>(bearService.allBears(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<Bear> getBearById(@PathVariable int id){
		Bear b = bearService.getBearById(id);
		if (b == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(b, HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/add")
	@ResponseBody
	public ResponseEntity<String> addBear(@RequestBody Bear bear){
		ResponseEntity<String> resp = null;
		try {
			bearService.createBear(bear);
			resp = new ResponseEntity<>("BEAR CREATED SUCCESSFULLY",HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE BEAR", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	
}
