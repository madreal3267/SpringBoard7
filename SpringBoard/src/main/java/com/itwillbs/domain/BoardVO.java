package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	// 프레임워크 내에서 참조형 사용을 권장(제네릭 캐스팅 중 문제 발생 가능성)
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private int viewcnt;
	
}
