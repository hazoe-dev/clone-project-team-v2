package com.web.dacn.dto.book;

import java.io.Serializable;
import java.util.Date;

import com.web.dacn.dto.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewBookDTO implements Serializable {
	private Long id;
	private String content;
	private Integer star;
	private Date mod_time;
	private UserDto user; 
	private BookDTO Book; 
}
