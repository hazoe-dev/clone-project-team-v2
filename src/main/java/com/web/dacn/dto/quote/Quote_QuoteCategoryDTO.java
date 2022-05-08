package com.web.dacn.dto.quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote_QuoteCategoryDTO {
	private Long id;
	private QuoteDto quote;
	private QuoteCategoryDto category;
}
