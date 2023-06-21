package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageRenderController {

	@GetMapping("/generate")
	public ResponseEntity<String> generateMessage() {
		// get system date and time
		LocalDateTime Idt = LocalDateTime.now();
		// get the current hour of the day
		int hour = Idt.getHour();
		String body = null;
		if (hour < 12)
			body = "Good Morng";
		else if (hour < 16)
			body = "Good Noon";
		else if (hour < 20)
			body = "Good Eveng";
		else
			body = "Good night";
	

	HttpStatus status = HttpStatus.OK;
	
	ResponseEntity<String> entity = new ResponseEntity<>(body,status);
	return entity;
}}