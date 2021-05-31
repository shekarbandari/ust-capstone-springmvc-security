package com.ust.pms.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class ForgotPassword {

	@NotBlank
	private String emailId;
	@NotBlank(message = "user name is mandatory")
	private String username;

}
