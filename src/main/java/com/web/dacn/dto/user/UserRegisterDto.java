package com.web.dacn.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
	private String name;
	private String fullname;
	private String password;
	private String email;
}
