package com.onetrillion.trip.board;

public class OftenDTO {
                                             // @@ 자주하는질문   [10/11 월 한보영]

//	CREATE TABLE Tril_Often(
//	of_seq number(5) NOT NULL PRIMARY KEY,
//	of_title varchar2(100)  ,
//	of_content varchar2(2000) 
//	);
	
	private int of_seq ; //자주묻는 질문 seq
	private String of_title ; //제목
	private String of_content ; //내용
	
	public OftenDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public OftenDTO(int of_seq, String of_title, String of_content) {
		super();
		this.of_seq = of_seq;
		this.of_title = of_title;
		this.of_content = of_content;
	}
	@Override
	public String toString() {
		return "OftenDTO [of_seq=" + of_seq + ", of_title=" + of_title + ", of_content=" + of_content + "]";
	}

	public int getOf_seq() {
		return of_seq;
	}
	public void setOf_seq(int of_seq) {
		this.of_seq = of_seq;
	}
	public String getOf_title() {
		return of_title;
	}
	public void setOf_title(String of_title) {
		this.of_title = of_title;
	}
	public String getOf_content() {
		return of_content;
	}
	public void setOf_content(String of_content) {
		this.of_content = of_content;
	}
	
	
	
	
	
}
