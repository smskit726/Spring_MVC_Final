package com.biz.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.qna.model.QuestionVO;
import com.biz.qna.service.QuestionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class QuestionController {
	
	private final QuestionService qService;

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id")String q_seq, Model model) {
		long longSeq = Long.valueOf(q_seq);
		QuestionVO qVO = qService.findById(longSeq);
		
		model.addAttribute("QUESTION", qVO);
		return "question/detail";
	}
	
	@RequestMapping(value = "/q_write", method = RequestMethod.GET)
	public String write(Model model) {
		
		QuestionVO qVO = qService.newQuestion();
		model.addAttribute("QUESTION", qVO);
		return "question/write";
	}
	
	@RequestMapping(value = "/q_write", method=RequestMethod.POST)
	public String write(@ModelAttribute QuestionVO qVO) {
		
		qService.insert(qVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String q_seq) {
		
		long longSeq = Long.valueOf(q_seq);
		qService.delete(longSeq);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String q_seq, @ModelAttribute QuestionVO qVO, Model model) {
		
		long longSeq = Long.valueOf(q_seq);
		qVO = qService.findById(longSeq);
		
		model.addAttribute("QUESTION", qVO);
		return "question/write";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute QuestionVO qVO) {
		qService.update(qVO);
		return "redirect:/";
	}
}
