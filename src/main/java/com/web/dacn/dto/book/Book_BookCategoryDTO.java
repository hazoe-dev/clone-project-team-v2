package com.web.dacn.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book_BookCategoryDTO {
	private Long id;
	private BookDTO book;
	private BookCategoryDTO category;
}
