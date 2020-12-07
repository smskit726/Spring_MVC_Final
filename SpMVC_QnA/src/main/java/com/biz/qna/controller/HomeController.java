package com.biz.qna.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.qna.model.QuestionVO;
import com.biz.qna.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final QuestionService qService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<QuestionVO> questions = qService.selectAll();
		model.addAttribute("QUESTIONS", questions);
		return "home";
	}
	
}
