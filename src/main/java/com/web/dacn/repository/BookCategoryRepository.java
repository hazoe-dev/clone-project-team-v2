
package com.web.dacn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.book.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>{
	BookCategory findById(int id);
	BookCategory findByName(String name);
	

}

