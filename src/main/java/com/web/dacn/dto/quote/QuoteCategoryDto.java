package com.web.dacn.dto.quote;

import java.io.Serializable;

import com.web.dacn.entity.quote.QuoteCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteCategoryDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private Long id;
	private String slug;
	private String name;
	private int view;
	private String metaTitle;
	private String metaDescription;
	private Integer status;
	private Long parent_id;
	private QuoteCategory quoteCategory;
}
