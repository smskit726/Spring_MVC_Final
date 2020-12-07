package com.biz.qna.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AnswerVO {

	private long aSeq;
	private String aWriter;
	private String aDate;
	private String aTime;
	private String aTitle;
	private String aContent;
	
}
