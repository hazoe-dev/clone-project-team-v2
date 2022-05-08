package com.web.dacn.entity.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "bookcategory")
@AllArgsConstructor
@NoArgsConstructor
public class BookCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", 
			nullable = false, 
			columnDefinition = "NVARCHAR(100)")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = BookCategory.class)
	@JoinColumn(name = "parent_id")
	@JsonIgnore
	private BookCategory parentBookCategory;
	
	@Column(name = "view", 
			nullable = false, 
			columnDefinition = "INTEGER DEFAULT 1")
	private Integer view;
	
	@Column(name = "slug", 
			nullable = false,
			columnDefinition = "VARCHAR(2000)")
	private String slug;
	
	@Column(name = "meta_title")
	private String metaTitle;
	
	@Column(name = "meta_description", 
			columnDefinition = "NVARCHAR(100)")
	private String metaDescription;
	
	@Column(name = "status", 
			nullable = false, 
			columnDefinition = "INTEGER DEFAULT 1")
	private Integer status;

	@ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
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
        if (!(obj instanceof BookCategory)) {
            return false;
        }
        BookCategory that = (BookCategory) obj;
        return  Objects.equals(getId(),that.getId());
    }
}
