package com.biz.qna.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.qna.model.QuestionVO;
import com.biz.qna.sql.QnaSQL;

public interface QuestionDao {
	
	@Select("SELECT * FROM tbl_question ORDER BY q_date DESC, q_time DESC")
	public List<QuestionVO> selectAll();
	
	@Select("SELECT * FROM tbl_question WHERE q_seq = #{q_seq}")
	public QuestionVO findById(long q_seq);
	
	@InsertProvider(type = QnaSQL.class, method = "q_insert")
	@SelectKey(keyProperty = "q_seq", statement = "SELECT seq_question.NEXTVAL FROM DUAL",
				resultType = Long.class, before = true)
	public int insert(QuestionVO qVO);
	
	
	@UpdateProvider(type = QnaSQL.class, method="q_update")
	public int update(QuestionVO qVO);
	
	@Delete("DELETE FROM tbl_question WHERE q_seq=#{q_seq}")
	public int delete(long q_seq);

}
