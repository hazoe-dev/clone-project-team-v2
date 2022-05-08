package com.web.dacn.dto.quote;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.dacn.entity.quote.CommentQuote;
import com.web.dacn.entity.quote.Quote;
import com.web.dacn.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentQuoteDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String content;
	private Date mod_time;
	private CommentQuote commentQuote;
	private User user;
	private Quote quote;
	private List<CommentQuote> commentQuotes = new ArrayList<>();
}
