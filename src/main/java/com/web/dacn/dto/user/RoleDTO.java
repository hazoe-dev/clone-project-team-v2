package com.web.dacn.dto.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {
	private Long id;
	private String name;
	private List<UserDto> users;

}