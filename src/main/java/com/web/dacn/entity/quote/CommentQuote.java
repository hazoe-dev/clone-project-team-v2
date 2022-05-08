package com.web.dacn.entity.quote;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.dacn.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="commentquote")
public class CommentQuote implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mod_time")
	private Date modTime; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name="parent_id")
	@JsonIgnore
	private CommentQuote commentQuote;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user; 
	
	@ManyToOne
	@JoinColumn(name="quote_id")
	@JsonIgnore
	private Quote quote; 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commentQuote", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Collection<CommentQuote> commentQuotes = new ArrayList<>();
	

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentQuote)) {
            return false;
        }
        CommentQuote that = (CommentQuote) obj;
        return  Objects.equals(getId(),that.getId());
    }
	
	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }
 
}
