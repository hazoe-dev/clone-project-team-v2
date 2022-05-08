package com.web.dacn.dto.user;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
	private boolean rememberMe = false;

}

