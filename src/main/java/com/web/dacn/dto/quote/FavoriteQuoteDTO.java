package com.web.dacn.dto.quote;

import com.web.dacn.dto.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteQuoteDTO {
	private Long id;
	private UserDto user;
	private QuoteDto book;
}
