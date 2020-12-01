package com.biz.bbs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.model.EmployVO;
import com.biz.bbs.service.EmployService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class EmployAPIController {

	
	private final EmployService empService;
	
	public EmployAPIController(EmployService empService) {
		this.empService = empService;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<EmployVO> empList(){
		
		List<EmployVO> empList = empService.selectAll(); 
		return empList;
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public EmployVO empItem(@PathVariable("id") String id) {
		long long_id = Long.valueOf(id); 
		EmployVO empVO = empService.findBySeq(long_id);		
		return empVO;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public List<EmployVO> insert() {
		EmployVO empVO = empService.buildVO();
		empService.insert(empVO);
		return this.empList();
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public List<EmployVO> update(@PathVariable("id") String id) {
		long long_id = Long.valueOf(id);
		EmployVO empVO = empService.findBySeq(long_id);
		empService.update(empVO);
		return this.empList();
	}
	
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public List<EmployVO> delete(@PathVariable("id") String id){
		long long_id = Long.valueOf(id);	
		empService.delete(long_id);
		return this.empList();
	}

}
