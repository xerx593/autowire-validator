package com.stackoverlow.autowire.validation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.stackoverlow.autowire.validation.validation.MyValid;

import lombok.Data;

@Data
public class SomeDto {

	@NotBlank
	private String name;

	@NotBlank
	@Email
	private String email;

	@MyValid
	private String custom;

}