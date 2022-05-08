package com.web.dacn.dto.book;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.web.dacn.dto.user.AuthorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthorDTO {
	private Long id;
	private BookDTO book;
	private AuthorDTO author;
}
