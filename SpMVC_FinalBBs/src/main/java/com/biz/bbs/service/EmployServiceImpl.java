package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.EmployDao;
import com.biz.bbs.model.EmployVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("empServiceV1")
public class EmployServiceImpl implements EmployService{

	private final EmployDao empDao;
	
	public EmployServiceImpl(EmployDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public List<EmployVO> selectAll() {
		List<EmployVO> empList = empDao.selectAll();
		return empList;
	}

	@Override
	public EmployVO findBySeq(long long_id) {
		EmployVO empItem = empDao.findById(long_id);
		return empItem;
	}

	@Override
	public int insert(EmployVO empVO) {
		int ret = empDao.insert(empVO);
		if(ret > 0) {
			log.debug("데이터 추가 완료", ret);
		}
		
		return ret;
	}

	@Override
	public int update(EmployVO empVO) {
		empVO.setFirst_name("순신");
		empVO.setLast_name("이");
		int ret = empDao.update(empVO);
		if(ret > 0) {
			log.debug("{}번 데이터 수정 완료", empVO.getId());
		}
		return ret;
	}

	@Override
	public int delete(long long_id) {
		int ret = empDao.delete(long_id);
		
		if(ret>0) {
			log.debug("데이터 {}개 삭제", ret);
		}		
		return ret;
	}

	@Override
	public EmployVO buildVO() {
		EmployVO empVO = EmployVO.builder()
				.first_name("보고").last_name("장")
				.address("대전광역시").tel("010-4444-4444")
				.email("jkl@gmail.com").build();
		return empVO;
	}
	
}
