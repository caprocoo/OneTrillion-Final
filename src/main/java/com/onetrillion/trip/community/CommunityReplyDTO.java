package com.onetrillion.trip.community;

public class CommunityReplyDTO {
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 커뮤니티 댓글[10/19 한보영]
//	--[커뮤니티  TABLE ]--
//	-- PK : re_seq 
//	-- FK : com_seq 
//	--not null : re_seq , com_seq 
//
//	CREATE TABLE TRIL_community_reply (  --커뮤니티 댓글
//	   re_seq NUMBER(10) NOT NULL,  
//	   com_seq NUMBER(10) NOT NULL,
//	   parent_seq NUMBER(10), 
//	   re_depth NUMBER(10),
//	   re_content CLOB,
//	   re_writer VARCHAR2(100),
//	   re_psw VARCHAR2(30),
//	   re_date VARCHAR2(30),
//	   CONSTRAINT pk_re_seq PRIMARY KEY(re_seq),
//	   CONSTRAINT "fk_com_seq_reply" FOREIGN KEY(com_seq) 
//	       REFERENCES TRIL_community(com_seq) ON DELETE CASCADE
//	);
//
//	--[ 커뮤니티 SEQUENCE]--
//	CREATE SEQUENCE re_seq START WITH 1 INCREMENT BY 1;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	
	
	private int re_seq ;  //댓글 seq
	private int com_seq ;  //커뮤니티 게시판 글 seq
	private int parent_seq ;  //부모 seq
	private int re_depth ;  //깊이
	private String re_content ; //내용
	private String re_writer ;  //글쓴이
	private String re_psw ; //비밀번호
	private String re_date ; //댓글 날짜
	
	
	public CommunityReplyDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CommunityReplyDTO(int re_seq, int com_seq, int parent_seq, int re_depth, String re_content, String re_writer,
			String re_psw, String re_date) {
		super();
		this.re_seq = re_seq;
		this.com_seq = com_seq;
		this.parent_seq = parent_seq;
		this.re_depth = re_depth;
		this.re_content = re_content;
		this.re_writer = re_writer;
		this.re_psw = re_psw;
		this.re_date = re_date;
	}

	@Override
	public String toString() {
		return "CommunityReplyDTO [re_seq=" + re_seq + ", com_seq=" + com_seq + ", parent_seq=" + parent_seq
				+ ", re_depth=" + re_depth + ", re_content=" + re_content + ", re_writer=" + re_writer + ", re_psw="
				+ re_psw + ", re_date=" + re_date + "]";
	}

	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public int getCom_seq() {
		return com_seq;
	}
	public void setCom_seq(int com_seq) {
		this.com_seq = com_seq;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	public int getRe_depth() {
		return re_depth;
	}
	public void setRe_depth(int re_depth) {
		this.re_depth = re_depth;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_writer() {
		return re_writer;
	}
	public void setRe_writer(String re_writer) {
		this.re_writer = re_writer;
	}
	public String getRe_psw() {
		return re_psw;
	}
	public void setRe_psw(String re_psw) {
		this.re_psw = re_psw;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}
	
	
	
	
	
	

}
