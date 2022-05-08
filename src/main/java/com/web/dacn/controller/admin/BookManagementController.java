package com.web.dacn.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.dacn.dto.book.BookDTO;
import com.web.dacn.service.admin.IBookService;

@Controller
@RequestMapping("/admin")
public class BookManagementController {

	@Autowired
	IBookService bookService;

	@RequestMapping("/books")
	public String getBooks(Model model, HttpSession session, HttpServletRequest req) {
		return getBooksByPage(model, session, 0, req);
	}

	@RequestMapping("/books/{page}")
	public String getBooksByPage(Model model, HttpSession session, @PathVariable("page") int currentpage,
			HttpServletRequest req) {

		HashMap<Long, List<String>> readFormats = new HashMap<Long, List<String>>();

		Page<BookDTO> booksInPage = bookService.getBooksByPage(currentpage);
		List<BookDTO> books = booksInPage.getContent();

		for (BookDTO book : books) {
			readFormats.put(book.getId(), bookService.getReadFromat(book.getId()));
		}

		List<Integer> totalPages = new ArrayList<Integer>();
		for (int i = 0; i < booksInPage.getTotalPages(); i++) {
			totalPages.add(i);
		}

		model.addAttribute("totalPages", totalPages);
		model.addAttribute("total", booksInPage.getTotalElements());
		model.addAttribute("books", books);
		model.addAttribute("readFormats", readFormats);
		model.addAttribute("currentpage", currentpage);

		return "adminListBook";
	}

	@PostMapping("search")
	public String search(Model model, HttpSession session, HttpServletRequest req) {
		return searchByPage(model, 0, session, req);
	}

	@RequestMapping("search/{page}")
	public String searchByPage(Model model, @PathVariable("page") int currentpage, HttpSession session,
			HttpServletRequest req) {
		String bookName, authorName, message = "";
		Page<BookDTO> booksInPage;
		List<BookDTO> results = new ArrayList<BookDTO>();
		List<Integer> totalPages = new ArrayList<Integer>();
		HashMap<Long, List<String>> readFormats = new HashMap<Long, List<String>>();

		if ((currentpage > 0) || (currentpage == 0 && !req.getMethod().equalsIgnoreCase("POST"))) {

			bookName = (String) session.getAttribute("bookName");
			authorName = (String) session.getAttribute("authorName");

		} else {

			bookName = req.getParameter("bookname");
			authorName = req.getParameter("authorname");

			session.setAttribute("bookName", bookName);
			session.setAttribute("authorName", authorName);

		}

		booksInPage = bookService.search(bookName, authorName, currentpage);
		results = booksInPage.getContent();

		for (BookDTO book : results) {
			readFormats.put(book.getId(), bookService.getReadFromat(book.getId()));
		}

		if (results.size() <= 0) {
			message = "No result";
			model.addAttribute("message", message);
		}
		for (int i = 0; i < booksInPage.getTotalPages(); i++) {
			totalPages.add(i);
		}

		model.addAttribute("searchPages", totalPages);
		model.addAttribute("readFormats", readFormats);
		model.addAttribute("total", booksInPage.getTotalElements());
		model.addAttribute("books", results);

		return "adminListBook";
	}


}
