package com.web.dacn.dto.user;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements Serializable{
	private Long id;
	private String slug;
	private String fullname;
	private Date birthday;
	private String address;
	private String phone;
	private String description;
	private Integer status;
	private Date mod_time;
	private UserDto user;
}
