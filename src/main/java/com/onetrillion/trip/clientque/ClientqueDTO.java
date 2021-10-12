package com.onetrillion.trip.clientque;


public class ClientqueDTO {

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 1:1 문의 [10/12 한보영]
//	--[1:1문의 TABLE ]--
//	-- PK : cl_seq 
//	-- FK : u_id 
//	--not null : cl_seq , u_id , u_nickName ,cl_Date  
//
//	CREATE TABLE Tril_ClientQue(
//	cl_seq number(5) NOT NULL PRIMARY KEY, 
//	u_id varchar2(30) NOT NULL,
//	u_nickName varchar2(20) NOT NULL,
//	cl_title varchar2(100),
//	cl_content varchar2(3000),
//	cl_Date DATE DEFAULT SYSDATE NOT NULL ,
//	CONSTRAINT "fk_u_id_client" FOREIGN KEY(u_id) REFERENCES tril_member(u_id)
//	);
//
//	--[ 1:1문의 SEQUENCE]--
//	CREATE SEQUENCE cl_seq START WITH 1 INCREMENT BY 1;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	private int cl_seq ; //1:1 문의 seq
	private String u_id ; //회원아이디
	private String u_nickName; //회원 닉네임
	private String cl_title; //제목
	private String cl_content; //내용
	private String cl_Date; //작성일
	private String cl_type ; //작성일
	
	public ClientqueDTO() {
		// TODO Auto-generated constructor stub
	}
		
	@Override
	public String toString() {
		return "ClientqueDTO [cl_seq=" + cl_seq + ", u_id=" + u_id + ", u_nickName=" + u_nickName + ", cl_title="
				+ cl_title + ", cl_content=" + cl_content + ", cl_Date=" + cl_Date + ", cl_type=" + cl_type + "]";
	}

	public ClientqueDTO(int cl_seq, String u_id, String u_nickName, String cl_title, String cl_content, String cl_Date,
			String cl_type) {
		super();
		this.cl_seq = cl_seq;
		this.u_id = u_id;
		this.u_nickName = u_nickName;
		this.cl_title = cl_title;
		this.cl_content = cl_content;
		this.cl_Date = cl_Date;
		this.cl_type = cl_type;
	}

	public int getCl_seq() {
		return cl_seq;
	}
	public void setCl_seq(int cl_seq) {
		this.cl_seq = cl_seq;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_nickName() {
		return u_nickName;
	}
	public void setU_nickName(String u_nickName) {
		this.u_nickName = u_nickName;
	}
	public String getCl_title() {
		return cl_title;
	}
	public void setCl_title(String cl_title) {
		this.cl_title = cl_title;
	}
	public String getCl_content() {
		return cl_content;
	}
	public void setCl_content(String cl_content) {
		this.cl_content = cl_content;
	}
	public String getCl_Date() {
		return cl_Date;
	}
	public void setCl_Date(String cl_Date) {
		this.cl_Date = cl_Date;
	}
	public String getCl_type() {
		return cl_type;
	}
	public void setCl_type(String cl_type) {
		this.cl_type = cl_type;
	}
	
	
	
}
