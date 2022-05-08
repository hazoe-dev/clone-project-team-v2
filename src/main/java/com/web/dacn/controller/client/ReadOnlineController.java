package com.web.dacn.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.dacn.dto.book.BookDTO;
import com.web.dacn.dto.book.OnlineDTO;
import com.web.dacn.service.client.ReadOnlineService;

@Controller
@RequestMapping("/doc-online")
public class ReadOnlineController {	
	@Autowired
	private ReadOnlineService readOnlineService;
	
	@GetMapping("/{slug}")
	private ModelAndView readOnline(@PathVariable(value = "slug") String slug, @RequestParam(name = "chapter") Integer chapter) {
		if(chapter == null) chapter = 1;
		
		ModelAndView modelAndView = new ModelAndView();
		try {
			BookDTO bookDTO = readOnlineService.loadBook(slug);
			if(bookDTO == null)
				modelAndView.setViewName("404");
			OnlineDTO onlineDTO = readOnlineService.loadChapter(bookDTO.getId(), chapter);
			modelAndView.addObject("onlineSelected", onlineDTO);
			modelAndView.addObject("existsPdf", readOnlineService.existsPdfRead(bookDTO.getId()));
			modelAndView.addObject("existsAudio", readOnlineService.existsAudio(bookDTO.getId()));
			modelAndView.addObject("book", bookDTO);
			modelAndView.setViewName("onlineReadPage");
		} catch (Exception e) {
			modelAndView.setViewName("404");
		}
		return modelAndView;
	}
}
