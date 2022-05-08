package com.web.dacn.dto.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.dacn.dto.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentBookDTO implements Serializable{
	private Long id;
	private String content;
	private Date mod_time;
	private CommentBookDTO commentBook;
	private UserDto user; 
	private BookDTO book; 
	private List<CommentBookDTO> commentBooks = new ArrayList<CommentBookDTO>();
}
