package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorOperationController {
	@GetMapping("/wish")
	public ResponseEntity<String>displayWishMessge() {
		return new ResponseEntity<String>("Good Morning",HttpStatus.OK);
	}

}
