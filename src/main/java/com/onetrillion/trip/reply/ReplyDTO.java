package com.onetrillion.trip.reply;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReplyDTO {
	
	private int reply_seq;
	private String u_id;
	private int pd_seq;
	private String reply_title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reply_date;
	private String reply_content;
	private int reply_rate;
	
	public ReplyDTO() {}
	public ReplyDTO(int reply_seq, String u_id, int pd_seq, String reply_title, LocalDate reply_date,
			String reply_content, int reply_rate) {
		this.reply_seq = reply_seq;
		this.u_id = u_id;
		this.pd_seq = pd_seq;
		this.reply_title = reply_title;
		this.reply_date = reply_date;
		this.reply_content = reply_content;
		this.reply_rate = reply_rate;
	}

	public String getReply_title() {
		return reply_title;
	}
	public void setReply_title(String reply_title) {
		this.reply_title = reply_title;
	}
	public int getReply_seq() {
		return reply_seq;
	}
	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getPd_seq() {
		return pd_seq;
	}
	public void setPd_seq(int pd_seq) {
		this.pd_seq = pd_seq;
	}

	public LocalDate getReply_date() {
		return reply_date;
	}
	public void setReply_date(LocalDate reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public int getReply_rate() {
		return reply_rate;
	}
	public void setReply_rate(int reply_rate) {
		this.reply_rate = reply_rate;
	}
	@Override
	public String toString() {
		return "ReplyDTO [reply_seq=" + reply_seq + ", u_id=" + u_id + ", pd_seq=" + pd_seq + ", reply_title="
				+ reply_title + ", reply_date=" + reply_date + ", reply_content=" + reply_content + ", reply_rate="
				+ reply_rate + "]";
	}

	
}
