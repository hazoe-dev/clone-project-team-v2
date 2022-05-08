package com.web.dacn.dto.quote;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.web.dacn.entity.quote.CommentQuote;
import com.web.dacn.entity.quote.QuoteCategory;
import com.web.dacn.entity.quote.ReviewQuote;
import com.web.dacn.entity.user.Author;
import com.web.dacn.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String slug;
	private String thumbnail;
	private String content;
	private int view;
	private Author author;
	private String metaTitle;
	private String metaDescription;
	private Integer status;
	private Date mod_time;
	private User user;
	private Set<QuoteCategory> quoteCategories = new HashSet<>();
	private Set<ReviewQuote> reviewQuotes = new HashSet<>();
	private Set<CommentQuote> commentQuotes = new HashSet<>();
}
