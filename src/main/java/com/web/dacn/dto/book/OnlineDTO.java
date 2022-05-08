package com.web.dacn.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlineDTO {
	private Long id;
	private String name;
	private String content;
	private Integer priority;
	private BookDTO book;
}
