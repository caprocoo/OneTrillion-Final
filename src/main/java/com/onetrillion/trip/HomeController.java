package com.onetrillion.trip;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.impl.BoardService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	public BoardService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {


		List<BoardDTO> aloneList = service.theme("alone");
		List<BoardDTO> familyList = service.theme("family");
		List<BoardDTO> coupleList = service.theme("couple");
		List<BoardDTO> petList = service.theme("pet");
		List<BoardDTO> honeymoonList = service.theme("honeymoon");
		List<BoardDTO> friendList = service.theme("friend");

		model.addAttribute("aloneList", aloneList);
		model.addAttribute("familyList", familyList);
		model.addAttribute("coupleList", coupleList);
		model.addAttribute("petList", petList);
		model.addAttribute("honeymoonList", honeymoonList);
		model.addAttribute("friendList", friendList);
		return "board/mainPage";
	}
	
}
