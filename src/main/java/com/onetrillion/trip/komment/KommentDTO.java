package com.onetrillion.trip.komment;

public class KommentDTO {
	
	private int kom_seq;
	private String u_id;
	private int reply_seq;
	private String u_nickName;
	private String kom_content;
	private String kom_date;
	
	public KommentDTO() {}

	public KommentDTO(int kom_seq, String u_id, int reply_seq, String u_nickName, String kom_content, String kom_date) {
		this.kom_seq = kom_seq;
		this.u_id = u_id;
		this.reply_seq = reply_seq;
		this.u_nickName = u_nickName;
		this.kom_content = kom_content;
		this.kom_date = kom_date;
	}

	public int getKom_seq() {
		return kom_seq;
	}

	public void setKom_seq(int kom_seq) {
		this.kom_seq = kom_seq;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getReply_seq() {
		return reply_seq;
	}

	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}

	public String getU_nickName() {
		return u_nickName;
	}

	public void setU_nickName(String u_nickName) {
		this.u_nickName = u_nickName;
	}

	public String getKom_content() {
		return kom_content;
	}

	public void setKom_content(String kom_content) {
		this.kom_content = kom_content;
	}

	public String getKom_date() {
		return kom_date;
	}

	public void setKom_date(String kom_date) {
		this.kom_date = kom_date;
	}

	@Override
	public String toString() {
		return "CommentDTO [kom_seq=" + kom_seq + ", u_id=" + u_id + ", reply_seq=" + reply_seq + ", u_nickName="
				+ u_nickName + ", kom_content=" + kom_content + ", kom_date=" + kom_date + "]";
	}

	
	
	
	
}
