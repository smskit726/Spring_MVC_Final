package com.biz.qna.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionVO {

	private long q_seq;
	private String q_writer;
	private String q_date;
	private String q_time;
	private String q_title;
	private String q_content;
	
}
