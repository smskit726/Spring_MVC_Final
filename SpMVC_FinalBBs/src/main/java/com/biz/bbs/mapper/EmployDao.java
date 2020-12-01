package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.bbs.model.EmployVO;
import com.biz.bbs.sql.EmploySQL;

public interface EmployDao {
	
	@Select("SELECT * FROM tbl_employees ORDER BY last_name")
	public List<EmployVO> selectAll();
	
	@Select("SELECT * FROM tbl_employees WHERE id = #{id}")
	public EmployVO findById(long id);
	
	@InsertProvider(type = EmploySQL.class, method = "emp_insert")
	@SelectKey(keyProperty = "id", statement = "SELECT seq_employees.NEXTVAL FROM DUAL",
				resultType = Long.class, before = true)
	public int insert(EmployVO empVO);
	
	@UpdateProvider(type = EmploySQL.class, method = "emp_update")
	public int update(EmployVO empVO);
	
	@Delete("DELETE FROM tbl_employees WHERE id=#{id}")
	public int delete(long id);
}
