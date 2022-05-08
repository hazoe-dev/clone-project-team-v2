package com.web.dacn.entity.book;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.dacn.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "bookmark")
@AllArgsConstructor
@NoArgsConstructor
public class BookMark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	@JsonIgnore
	private Book book;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "audio_id")
	@JsonIgnore
	private Audio audio;

	@ManyToOne
	@JoinColumn(name = "online_id")
	@JsonIgnore
	private Online online;

	@ManyToOne
	@JoinColumn(name = "pdf_id")
	@JsonIgnore
	private Pdf pdf;

	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BookMark)) {
            return false;
        }
        BookMark that = (BookMark) obj;
        return  Objects.equals(getId(),that.getId());
    }
}
