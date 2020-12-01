package com.biz.bbs.service;

import java.util.List;

import com.biz.bbs.model.EmployVO;

public interface EmployService {

	public List<EmployVO> selectAll();
	public EmployVO findBySeq(long long_id);

	public int insert(EmployVO empVO);
	public int update (EmployVO empVO);
	public int delete(long long_id);
	
	public EmployVO buildVO();
}
