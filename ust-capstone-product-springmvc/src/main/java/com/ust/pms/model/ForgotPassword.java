package com.ust.pms.model;

import javax.persistence.Id;

import lombok.Data;


@Data
public class ForgotPassword {

	@Id
	private String emailId;

}
