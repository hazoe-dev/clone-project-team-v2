package com.web.dacn.entity.quote;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="reviewquote")
public class ReviewQuote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String content;
	private int star;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mod_time")
	private Date modTime;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user; 
	
	@ManyToOne
	@JoinColumn(name="quote_id")
	@JsonIgnore
	private Quote quote; 
	
	
	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReviewQuote)) {
            return false;
        }
        ReviewQuote that = (ReviewQuote) obj;
        return  Objects.equals(getId(),that.getId());
    }
}
