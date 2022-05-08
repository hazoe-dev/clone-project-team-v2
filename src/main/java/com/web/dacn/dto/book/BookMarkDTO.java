package com.web.dacn.dto.book;

import com.web.dacn.dto.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookMarkDTO {
	private Long id;
	private BookDTO book;
	private UserDto user;
	private AudioDTO audio;
	private OnlineDTO online;
	private PdfDTO pdf;
}
