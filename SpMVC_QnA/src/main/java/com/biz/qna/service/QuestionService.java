package com.biz.qna.service;

import java.util.List;

import com.biz.qna.model.QuestionVO;

public interface QuestionService {

	public QuestionVO newQuestion();
	
	public List<QuestionVO> selectAll();
	public QuestionVO findById(long q_seq);
	public int insert(QuestionVO qVO);
	public int update(QuestionVO qVO);
	public int delete(long q_seq);
}
