package com.web.dacn.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.dacn.dto.book.AudioDTO;
import com.web.dacn.dto.book.BookDTO;
import com.web.dacn.service.client.AudioService;

@Controller
@RequestMapping("/audio")
public class AudioController {
	@Autowired
	private AudioService audioService;
	
	@GetMapping("/{slug}")
	private ModelAndView getAudioBook(@PathVariable(value = "slug") String slug) {
		ModelAndView mav = new ModelAndView("audioPage");
		
		BookDTO bookDTO = audioService.findBookBySlug(slug);
		if(bookDTO == null)
			return new ModelAndView("404");
		
		List<AudioDTO> audioDTOs = audioService.findAudiosByBook(bookDTO.getId());

		if(audioDTOs == null || audioDTOs.size()<1) {
			return new ModelAndView("404");
		}
		
		AudioDTO audioSelected = audioDTOs.get(0);
		audioDTOs.remove(0);
		
		mav.addObject("existsPdf", audioService.existsPdf((long)bookDTO.getId()));
		mav.addObject("existsEbook", audioService.existsEbook((long)bookDTO.getId()));
		
		mav.addObject("bookDTO", bookDTO);
		mav.addObject("audioSelected", audioSelected);
		mav.addObject("audioDTOs", audioDTOs);
		
		return mav;
	}
}
