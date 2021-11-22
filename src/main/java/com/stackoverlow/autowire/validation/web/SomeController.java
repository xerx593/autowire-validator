package com.stackoverlow.autowire.validation.web;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackoverlow.autowire.validation.dto.SomeDto;

@RestController
public class SomeController {

	@PostMapping("/some")
	ResponseEntity<String> addUser(@Valid @RequestBody SomeDto dto) {
		return ResponseEntity.ok("Request is valid");
	}

}
