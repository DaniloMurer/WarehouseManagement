package com.danilojakob.warehousemanagement.dtos;

import lombok.Data;

import java.util.List;

@Data
public class SignUpDto {

	private String username;
	private String password;
	private String repeatPassword;
	private List<String> roles;

}
