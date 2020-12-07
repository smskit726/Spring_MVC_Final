package com.biz.qna.sql;

import org.apache.ibatis.jdbc.SQL;

public class QnaSQL {

	public String q_insert() {
		SQL sql = new SQL();
		sql.INSERT_INTO("tbl_question");
		sql.INTO_COLUMNS("q_seq").INTO_VALUES("#{q_seq}");
		sql.INTO_COLUMNS("q_date").INTO_VALUES("#{q_date}");
		sql.INTO_COLUMNS("q_time").INTO_VALUES("#{q_time}");
		sql.INTO_COLUMNS("q_writer").INTO_VALUES("#{q_writer}");
		sql.INTO_COLUMNS("q_title").INTO_VALUES("#{q_title}");
		sql.INTO_COLUMNS("q_content").INTO_VALUES("#{q_content}");
		
		return sql.toString();
	}
	
	public String q_update() {
		SQL sql = new SQL();
		sql.UPDATE("tbl_question");
		sql.SET("q_title = #{q_title}");
		sql.SET("q_content = #{q_content}");
		sql.WHERE("q_seq = #{q_seq}");
		
		return sql.toString();
	}
}
