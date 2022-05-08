package com.web.dacn.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.web.dacn.entity.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value = "select * from book where status <> 0 order by mod_time desc", nativeQuery = true)
	Page<Book> findAll(Pageable paeable);

	@Query(value = "select * from book b" + " join book_author ba on b.`id`=ba.`book_id` "
			+ " join `author` a on a.id = ba.`author_id` "
			+ " where b.name like ?1% and a.fullname like ?2%  group by b.id ", nativeQuery = true)
	Page<Book> search(String bookName, String authorName, Pageable pageable);

	Optional<Book> findOneBySlug(String slug);
}
