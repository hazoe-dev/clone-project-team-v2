package com.web.dacn.dto.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.dacn.dto.user.AuthorDTO;
import com.web.dacn.dto.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	private Long id;
	private String name;
	private String thumbnail;
	private Integer view;
	private Double price;
	private Boolean vip;
	private String description;
	private String slug;
	private String metaTitle;
	private String metaDescription;
	private Integer status;
	private Date mod_time;
	private UserDto user;
	private List<AuthorDTO> authors = new ArrayList<AuthorDTO>();
	private List<BookCategoryDTO> categories = new ArrayList<>();
	private List<AudioDTO> audios = new ArrayList<>();
	private List<OnlineDTO> onlines = new ArrayList<>();
	private List<PdfDTO> pdfs = new ArrayList<>();
}
