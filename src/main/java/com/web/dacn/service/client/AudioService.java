package com.web.dacn.service.client;

import java.util.List;

import com.web.dacn.dto.book.AudioDTO;
import com.web.dacn.dto.book.BookDTO;

public interface AudioService {
	public BookDTO findBookBySlug(String slug);
	
	public List<AudioDTO> findAudiosByBook(Long bookId);
	
	public boolean existsPdf(Long id);

	public boolean existsEbook(Long id);
}
