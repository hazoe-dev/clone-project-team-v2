package com.web.dacn.entity.quote;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Formula;

import com.web.dacn.entity.user.Author;
import com.web.dacn.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "nvarchar(2000) NOT NULL", unique = true)
	private String slug;
	@Column(columnDefinition = "nvarchar(1000)")
	private String thumbnail;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String content;
	private int view;
	@ManyToOne(targetEntity = Author.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private Author author;
	@Column(name = "meta_title")
	private String metaTitle;
	@Column(name = "meta_description")
	private String metaDescription;
	@ColumnDefault(value="1")
	private Integer status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date mod_time;
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "mod_user_id")
	private User user;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "quote_quotecategory", joinColumns = @JoinColumn(name = "quote_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<QuoteCategory> quoteCategories = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quote", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<ReviewQuote> reviewQuotes = new HashSet<>();

	@Formula("(select count(*) from reviewquote where reviewquote.quote_id=id)")
	private long feedback;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quote", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CommentQuote> commentQuotes = new HashSet<>();


	public double getAverageStar() {
		double sum = 0;
		if (reviewQuotes != null && reviewQuotes.size() > 0) {
			for (ReviewQuote reviewQuote : reviewQuotes) {
				sum += reviewQuote.getStar();
			}
			return (double) Math.ceil((sum / reviewQuotes.size()) * 2) / 2;
		}
		return 0;
	}

	public ReviewQuote getMyReview(Long userId) {
		double sum = 0;
		if (reviewQuotes != null && reviewQuotes.size() > 0) {
			for (ReviewQuote reviewQuote : reviewQuotes) {
				if (reviewQuote.getUser().getId().equals(userId)) {
					return reviewQuote;
				}
			}
		}
		return null;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Quote)) {
            return false;
        }
        Quote that = (Quote) obj;
        return  Objects.equals(getId(),that.getId());
    }
	
	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }

}
