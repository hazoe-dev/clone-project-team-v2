package com.web.dacn.entity.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.dacn.entity.book.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "nvarchar(2000) NOT NULL", unique=true)
	private String slug;
	
	private String fullname;
	
	private Date birthday;
	
	@Column(columnDefinition = "nvarchar(1000)")
	private String address;
	
	@Column(columnDefinition = "nvarchar(20)")
	private String phone;
	
	@Column(columnDefinition = "nvarchar(MAX)")
	private String description;
	
	private Integer status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date mod_time;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="mod_user_id")
	private User user;
	
	@ManyToMany(mappedBy = "authors")
	@JsonIgnore
	private List<Book> books = new ArrayList<>();
	

	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Author)) {
            return false;
        }
        Author that = (Author) obj;
        return  Objects.equals(getId(),that.getId());
    }	
}
