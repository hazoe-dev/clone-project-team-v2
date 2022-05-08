package com.web.dacn.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdfDTO {
	private Long id;
	private String name;
	private String url;
	private Integer priority;
	private BookDTO book;
}
