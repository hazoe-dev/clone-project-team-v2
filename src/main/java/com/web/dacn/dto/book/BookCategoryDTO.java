package com.web.dacn.dto.book;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCategoryDTO {
	private Long id;
	private String name;
	private BookCategoryDTO parentBookCategory;
	private Integer view;
	private String slug;
	private String metaTitle;
	private String metaDescription;
	private Integer status;
    private List<BookDTO> books = new ArrayList<>();
}
