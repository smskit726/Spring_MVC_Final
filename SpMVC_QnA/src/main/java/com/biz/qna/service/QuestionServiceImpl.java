package com.biz.qna.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.qna.mapper.QuestionDao;
import com.biz.qna.model.QuestionVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

	private final QuestionDao qDao;
	
	@Override
	public QuestionVO newQuestion() {
		
		LocalDateTime lDateTime = LocalDateTime.now();
		String lDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(lDateTime);
		String lTime = DateTimeFormatter.ofPattern("HH:mm:SS").format(lDateTime);
		
		QuestionVO qVO = QuestionVO.builder().q_date(lDate).q_time(lTime).build();
		return qVO;
	}
	
	@Override
	public List<QuestionVO> selectAll() {
		List<QuestionVO> questions = qDao.selectAll();
		return questions;
	}

	@Override
	public QuestionVO findById(long q_seq) {
		QuestionVO qVO = qDao.findById(q_seq);
		return qVO;
	}

	@Override
	public int insert(QuestionVO qVO) {
		int ret = qDao.insert(qVO);
		if(ret > 0) {
			log.debug("질문 등록 성공");
		} 
		return ret;
	}

	@Override
	public int update(QuestionVO qVO) {
		int ret = qDao.update(qVO);
		if(ret > 0) {
			log.debug("SEQ:{} 질문 수정 성공!",qVO.getQ_seq());
		}
		return ret;
	}

	@Override
	public int delete(long q_seq) {
		int ret =  qDao.delete(q_seq);
		if(ret > 0) {
			log.debug("SEQ:{} 질문 삭제 성공!", q_seq);
		}
		return ret;
	}
	
}
