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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_bookcategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book_BookCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = Book.class)
	@JoinColumn(name = "book_id")
	@JsonIgnore
	private Book book;

	@ManyToOne(targetEntity = BookCategory.class)
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private BookCategory category;

	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book_BookCategory)) {
            return false;
        }
        Book_BookCategory that = (Book_BookCategory) obj;
        return  Objects.equals(getId(),that.getId());
    }	
}
