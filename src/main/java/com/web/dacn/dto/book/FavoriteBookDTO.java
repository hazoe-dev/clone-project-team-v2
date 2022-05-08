package com.web.dacn.dto.book;

import com.web.dacn.dto.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteBookDTO {
	private Long id;
	private UserDto user;
	private BookDTO book;
}
