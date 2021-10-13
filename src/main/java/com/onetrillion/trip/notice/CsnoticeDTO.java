package com.onetrillion.trip.notice;

import java.sql.Date;
                                                           
public class CsnoticeDTO {
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 공지사항 [10/11 월 한보영]
//	CREATE TABLE Tril_Notice(
//			no_seq number(5) NOT NULL PRIMARY KEY,
//			ad_id varchar2(20) NOT NULL UNIQUE,
//			no_title varchar2(100)  ,
//			no_content varchar2(2000)  ,
//			no_Date DATE DEFAULT SYSDATE NOT NULL ,
//			CONSTRAINT "fk_ad_id" FOREIGN KEY(ad_id) REFERENCES tril_admin(ad_id)
//			);
// 	CREATE SEQUENCE no_seq START WITH 1 INCREMENT BY 1;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	private int no_seq ; //seq
	private String ad_id ; //외래키 관리자 아이디
	private String no_title; //제목
	private String no_content; //내용
	private Date no_Date; //작성일
	
	public CsnoticeDTO() {
		// TODO Auto-generated constructor stub
	}	
	
	public CsnoticeDTO(int no_seq, String ad_id, String no_title, String no_content, Date no_Date) {
		super();
		this.no_seq = no_seq;
		this.ad_id = ad_id;
		this.no_title = no_title;
		this.no_content = no_content;
		this.no_Date = no_Date;
	}
	
	@Override
	public String toString() {
		return "CsnoticeDTO [no_seq=" + no_seq + ", ad_id=" + ad_id + ", no_title=" + no_title + ", no_content="
				+ no_content + ", no_Date=" + no_Date + "]";
	}

	public int getNo_seq() {
		return no_seq;
	}
	public void setNo_seq(int no_seq) {
		this.no_seq = no_seq;
	}
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public Date getNo_Date() {
		return no_Date;
	}
	public void setNo_Date(Date no_Date) {
		this.no_Date = no_Date;
	}
	

	
	
	
	
}
