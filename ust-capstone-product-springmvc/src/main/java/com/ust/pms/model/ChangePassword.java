package com.ust.pms.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class ChangePassword {

	@NotBlank(message = "new password is mandatory")
	private String password;

	@NotBlank(message = "confirm password is mandatory")
	private String confirmPassword;

}
