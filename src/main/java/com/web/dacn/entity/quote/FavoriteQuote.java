package com.web.dacn.entity.quote;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.web.dacn.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favoritequote")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteQuote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(targetEntity = Quote.class)
	@JoinColumn(name = "quote_id")
	private Quote book;

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FavoriteQuote)) {
            return false;
        }
        FavoriteQuote that = (FavoriteQuote) obj;
        return  Objects.equals(getId(),that.getId());
    }
	
	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }

}
