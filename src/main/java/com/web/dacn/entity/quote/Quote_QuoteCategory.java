package com.web.dacn.entity.quote;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quote_quotecategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote_QuoteCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = Quote.class)
	@JoinColumn(name = "quote_id")
	private Quote quote;

	@ManyToOne(targetEntity = QuoteCategory.class)
	@JoinColumn(name = "category_id")
	private QuoteCategory category;
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Quote_QuoteCategory)) {
            return false;
        }
        Quote_QuoteCategory that = (Quote_QuoteCategory) obj;
        return  Objects.equals(getId(),that.getId());
    }
	
	@Override
    public int hashCode() {
		 return Objects.hash(getId());
    }

}
