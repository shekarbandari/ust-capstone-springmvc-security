package com.ust.pms.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserRegistration {
	@NotBlank(message = "user name is mandatory")
	private String username;

	@NotBlank(message = "new password is mandatory")
	private String password;

	@NotBlank(message = "confirm password is mandatory")
	private String confirmPassword;
	
	@NotBlank(message = "role is mandatory")
	private String role;

}
