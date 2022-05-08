package com.web.dacn.entity.book;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Data
@Entity
@Table(name = "pdf")
@AllArgsConstructor
@NoArgsConstructor
public class Pdf {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", 
			nullable = false,
			columnDefinition = "NVARCHAR(100)")
	private String name;
	
	@Column(name = "url", 
			nullable = false, 
			columnDefinition = "VARCHAR(2000)")
	private String url;
	
	@Column(name = "priority", nullable = false)
	private Integer priority;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Book.class)
	@JoinColumn(name = "book_id", nullable = false)
	@JsonIgnore
	private Book book;

	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pdf)) {
            return false;
        }
        Pdf that = (Pdf) obj;
        return  Objects.equals(getId(),that.getId());
    }

}
