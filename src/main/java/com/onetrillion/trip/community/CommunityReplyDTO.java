package com.onetrillion.trip.community;

public class CommunityReplyDTO {
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 커뮤니티 댓글[10/19 한보영]
	private String rno;
	private String com_seq;	//	댓글이 속한 게시글 번호 (받아와야 하는 값)
	private int grp;	//	댓글 그룹 번호 (모댓글과 거기에 속한 대댓글은 같은 grp를 가짐)
	private int grps;	//	그룹 내 댓글 순서 (오래된글 ~ 최신글  오름차순)
	private int grpl;	//	그룹내 댓글 깊이(댓글인지 대댓글인지)
	private String writer;
	private String re_content;
	private String wdate;
	
	
	
	@Override
	public String toString() {
		return "CommunityReplyDTO [rno=" + rno + ", com_seq=" + com_seq + ", grp=" + grp + ", grps=" + grps + ", grpl="
				+ grpl + ", writer=" + writer + ", re_content=" + re_content + ", wdate=" + wdate + "]";
	}
	public CommunityReplyDTO(String rno, String com_seq, int grp, int grps, int grpl, String writer, String re_content,
			String wdate) {
		super();
		this.rno = rno;
		this.com_seq = com_seq;
		this.grp = grp;
		this.grps = grps;
		this.grpl = grpl;
		this.writer = writer;
		this.re_content = re_content;
		this.wdate = wdate;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getCom_seq() {
		return com_seq;
	}
	public void setCom_seq(String com_seq) {
		this.com_seq = com_seq;
	}
	public int getGrp() {
		return grp;
	}
	public void setGrp(int grp) {
		this.grp = grp;
	}
	public int getGrps() {
		return grps;
	}
	public void setGrps(int grps) {
		this.grps = grps;
	}
	public int getGrpl() {
		return grpl;
	}
	public void setGrpl(int grpl) {
		this.grpl = grpl;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
	

}
