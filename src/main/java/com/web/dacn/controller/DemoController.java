package com.web.dacn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.dacn.dto.user.AuthorDTO;
import com.web.dacn.entity.user.Author;

@Controller
public class DemoController {
	@GetMapping("/home")
	public String getHomePage(Model model) {		
		return "homePage";
	}
	
	@GetMapping("/books")
	public String getDetailBookPage(Model model) {
		return "detailBookPage";
	}

	@GetMapping("/pdf-read")
	public String getPdfRead(Model model) {
		return "pdfReadPage";
	}

	@GetMapping("/online-read")
	public String getOnlineRead(Model model) {
		return "onlineReadPage";
	}

	@GetMapping("/auth")
	public String getAuthPage(Model model) {
		return "authPage";
	}

	@GetMapping("/audio")
	public String getAudio(Model model) {
		return "audioPage";
	}

	@GetMapping("/list-audio")
	public String getListAudio(Model model) {
		return "listAudioPage";
	}

//	@GetMapping("/admin/books")
//	public String getAdminListBook(Model model) {
//		return "adminListBook";
//	}
	
	@GetMapping("/admin/new-book")
	public String getAdminNewBook(Model model) {
		return "adminNewBook";
	}
	
	@GetMapping("/404")
	public String get404(Model model) {
		return "404";
	}
	
}
