package com.onetrillion.trip.adminAnswer;

                                                           
public class AdminAnsDTO  {
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 1:1 답변 [10/13 수 한보영]
//	CREATE TABLE Tril_ClientAnswer(
//	ans_seq number(5) NOT NULL PRIMARY KEY, 
//	ad_id  varchar2(20) NOT NULL,
//	cl_seq  number(5) NOT NULL,
//	ans_Date varchar2(100) NOT NULL,
//	ans_content  varchar2(3000),
//	CONSTRAINT "fk_a_id_answer" FOREIGN KEY(ad_id) REFERENCES tril_admin(ad_id),
//	CONSTRAINT "fk_cl_seq_answer" FOREIGN KEY(cl_seq) REFERENCES tril_clientque(cl_seq)
//	);
//	--[ 1:1 답변 SEQUENCE]--
//	CREATE SEQUENCE ans_seq START WITH 1 INCREMENT BY 1;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	private int ans_seq ; //PRIMARY KEY
	private String ad_id ; //관리자 아이디 (외래키)
	private int cl_seq ; //문의글 seq (외래키)
	private String ans_Date; //답글 작성일
	private String ans_content; //답글 내용
	
	
	public AdminAnsDTO() {
		// TODO Auto-generated constructor stub
	}	
	
	public AdminAnsDTO(int ans_seq, String ad_id, int cl_seq, String ans_Date, String ans_content) {
		super();
		this.ans_seq = ans_seq;
		this.ad_id = ad_id;
		this.cl_seq = cl_seq;
		this.ans_Date = ans_Date;
		this.ans_content = ans_content;
	}

	@Override
	public String toString() {
		return "AdminAnsDTO [ans_seq=" + ans_seq + ", ad_id=" + ad_id + ", cl_seq=" + cl_seq + ", ans_Date=" + ans_Date
				+ ", ans_content=" + ans_content + "]";
	}


	public int getAns_seq() {
		return ans_seq;
	}
	public void setAns_seq(int ans_seq) {
		this.ans_seq = ans_seq;
	}
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	public int getCl_seq() {
		return cl_seq;
	}
	public void setCl_seq(int cl_seq) {
		this.cl_seq = cl_seq;
	}
	public String getAns_Date() {
		return ans_Date;
	}
	public void setAns_Date(String ans_Date) {
		this.ans_Date = ans_Date;
	}
	public String getAns_content() {
		return ans_content;
	}
	public void setAns_content(String ans_content) {
		this.ans_content = ans_content;
	}

	
	
	
	
	
	
}
