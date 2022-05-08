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
import com.web.dacn.entity.quote.FavoriteQuote;
import com.web.dacn.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favoritebook")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@ManyToOne(targetEntity = Book.class)
	@JoinColumn(name = "book_id")
	@JsonIgnore
	private Book book;
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FavoriteBook)) {
            return false;
        }
        FavoriteBook that = (FavoriteBook) obj;
        return  Objects.equals(getId(),that.getId());
    }
	
	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }	
}
