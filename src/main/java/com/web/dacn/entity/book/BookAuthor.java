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
import com.web.dacn.entity.user.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(targetEntity = Book.class)
	@JoinColumn(name = "book_id")
	@JsonIgnore
	private Book book;

	@ManyToOne(targetEntity = Author.class)
	@JoinColumn(name = "author_id")
	@JsonIgnore
	private Author author;
	
	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BookAuthor)) {
            return false;
        }
        BookAuthor that = (BookAuthor) obj;
        return  Objects.equals(getId(),that.getId());
    }	
}
