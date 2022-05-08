package com.web.dacn.service.client;

import java.util.List;
import java.util.Set;

import com.web.dacn.dto.book.BookDTO;
import com.web.dacn.dto.book.OnlineDTO;
import com.web.dacn.dto.user.AuthorDTO;

public interface ReadOnlineService {
	BookDTO loadBook(String slug);
	OnlineDTO loadChapter(long bookId, int chapter);
	boolean existsPdfRead(long bookId);
	boolean existsAudio(long bookId);
}
