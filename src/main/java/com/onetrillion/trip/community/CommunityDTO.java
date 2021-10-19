package com.onetrillion.trip.community;

public class CommunityDTO {
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 커뮤니티 게시판[10/19 한보영]
//	--[커뮤니티  TABLE ]--
//	-- PK : com_seq  
//	--not null : com_seq , com_title  
//
//	CREATE TABLE TRIL_community (  --커뮤니티 게시판
//	   com_seq NUMBER(10) NOT NULL,  
//	   com_title VARCHAR2(300) NOT NULL, 
//	   com_content CLOB, 
//	   u_id VARCHAR2(30), 
//	   com_psw VARCHAR2(30), 
//	   com_date VARCHAR2(30), 
//     com_cnt  NUMBER(20),
//	   CONSTRAINT pk_com_seq PRIMARY KEY(com_seq), 
//	   CONSTRAINT "fk_u_id_community" FOREIGN KEY(u_id) REFERENCES tril_member(u_id)
//	);
//
//	--[ 커뮤니티 SEQUENCE]--
//	CREATE SEQUENCE com_seq START WITH 1 INCREMENT BY 1;	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	
	
	private int com_seq ;  //커뮤니티 게시판 글 seq
	private String com_title ; //제목
	private String com_content ;  //내용
	private String u_id ; //글쓴이
	private String com_psw ; //비밀번호
	private String com_date ; //작성일자	
	private int com_cnt; //조회수
	private int com_like;
	
	public CommunityDTO() {
		// TODO Auto-generated constructor stub
	}

	public CommunityDTO(int com_seq, String com_title, String com_content, String u_id, String com_psw, String com_date,
			int com_cnt, int com_like) {
		super();
		this.com_seq = com_seq;
		this.com_title = com_title;
		this.com_content = com_content;
		this.u_id = u_id;
		this.com_psw = com_psw;
		this.com_date = com_date;
		this.com_cnt = com_cnt;
		this.com_like = com_like;
	}

	@Override
	public String toString() {
		return "CommunityDTO [com_seq=" + com_seq + ", com_title=" + com_title + ", com_content=" + com_content
				+ ", u_id=" + u_id + ", com_psw=" + com_psw + ", com_date=" + com_date + ", com_cnt=" + com_cnt
				+ ", com_like=" + com_like + "]";
	}

	public int getCom_seq() {
		return com_seq;
	}

	public void setCom_seq(int com_seq) {
		this.com_seq = com_seq;
	}

	public String getCom_title() {
		return com_title;
	}

	public void setCom_title(String com_title) {
		this.com_title = com_title;
	}

	public String getCom_content() {
		return com_content;
	}

	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getCom_psw() {
		return com_psw;
	}

	public void setCom_psw(String com_psw) {
		this.com_psw = com_psw;
	}

	public String getCom_date() {
		return com_date;
	}

	public void setCom_date(String com_date) {
		this.com_date = com_date;
	}

	public int getCom_cnt() {
		return com_cnt;
	}

	public void setCom_cnt(int com_cnt) {
		this.com_cnt = com_cnt;
	}

	public int getCom_like() {
		return com_like;
	}

	public void setCom_like(int com_like) {
		this.com_like = com_like;
	}
	
 
	
	
	
	
	
}
