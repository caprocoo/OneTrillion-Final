package com.onetrillion.trip.memo;

public class MemoDTO {
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 관리자 메모 [10/17 한보영]
//	CREATE TABLE TRIL_ADMINMEMO (
//			   MEMO_SEQ NUMBER NOT NULL,
//			   AD_ID VARCHAR2(30) NOT NULL,
//			   AD_TO VARCHAR2(30) NOT NULL,
//			   MEMO_TYPE VARCHAR2(50) NOT NULL,
//			   MEMO_CONTENT VARCHAR2(1000),
//			   MEMO_DATE VARCHAR2(30),
//			   CONSTRAINT TRIL_ADMINMEMO_PK PRIMARY KEY (MEMO_SEQ),
//			   CONSTRAINT "FK_TRIL_ADMINMEMO_ad" FOREIGN KEY (AD_ID) REFERENCES TRIL_ADMIN(AD_ID)
//			);
//			CREATE SEQUENCE MEMO_SEQ START WITH 1 INCREMENT BY 1;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
	
	private int memo_seq ; //메모seq
	private String ad_id ; //관리자 id
	private String ad_to ; //관리자 ->관리자
	private String memo_type ; //메모 유형
	private String memo_content ; //메모 내용
	private String memo_date ; //작성 날짜
	
	public MemoDTO() {
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public String toString() {
		return "MemoDTO [memo_seq=" + memo_seq + ", ad_id=" + ad_id + ", ad_to=" + ad_to + ", memo_type=" + memo_type
				+ ", memo_content=" + memo_content + ", memo_date=" + memo_date + "]";
	}

	public MemoDTO(int memo_seq, String ad_id, String ad_to, String memo_type, String memo_content, String memo_date) {
		super();
		this.memo_seq = memo_seq;
		this.ad_id = ad_id;
		this.ad_to = ad_to;
		this.memo_type = memo_type;
		this.memo_content = memo_content;
		this.memo_date = memo_date;
	}
	
	public int getMemo_seq() {
		return memo_seq;
	}
	public void setMemo_seq(int memo_seq) {
		this.memo_seq = memo_seq;
	}
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_to() {
		return ad_to;
	}
	public void setAd_to(String ad_to) {
		this.ad_to = ad_to;
	}
	public String getMemo_type() {
		return memo_type;
	}
	public void setMemo_type(String memo_type) {
		this.memo_type = memo_type;
	}
	public String getMemo_content() {
		return memo_content;
	}
	public void setMemo_content(String memo_content) {
		this.memo_content = memo_content;
	}
	public String getMemo_date() {
		return memo_date;
	}
	public void setMemo_date(String memo_date) {
		this.memo_date = memo_date;
	}
	
	

	
	
	
	
}
