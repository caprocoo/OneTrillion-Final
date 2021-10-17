package com.onetrillion.trip.logRecord;

public class LogRecordDTO {
	
	private int log_seq;
	private String ad_id;
	private String log_part;
	private int per_seq;
	private String log_content;
	private String log_date;
	private String per_title;
	
	public LogRecordDTO() {}

	public LogRecordDTO(int log_seq, String ad_id, String log_part, int per_seq, String log_content, String log_date,
			String per_title) {
		this.log_seq = log_seq;
		this.ad_id = ad_id;
		this.log_part = log_part;
		this.per_seq = per_seq;
		this.log_content = log_content;
		this.log_date = log_date;
		this.per_title = per_title;
	}

	public int getLog_seq() {
		return log_seq;
	}

	public void setLog_seq(int log_seq) {
		this.log_seq = log_seq;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getLog_part() {
		return log_part;
	}

	public void setLog_part(String log_part) {
		this.log_part = log_part;
	}


	public int getPer_seq() {
		return per_seq;
	}
	public void setPer_seq(int per_seq) {
		this.per_seq = per_seq;
	}

	public String getLog_content() {
		return log_content;
	}

	public void setLog_content(String log_content) {
		this.log_content = log_content;
	}

	public String getLog_date() {
		return log_date;
	}

	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}

	public String getPer_title() {
		return per_title;
	}

	public void setPer_title(String per_title) {
		this.per_title = per_title;
	}

	@Override
	public String toString() {
		return "LogRecordDTO [log_seq=" + log_seq + ", ad_id=" + ad_id + ", log_part=" + log_part + ", per_seq="
				+ per_seq + ", log_content=" + log_content + ", log_date=" + log_date + ", per_title=" + per_title
				+ "]";
	}

	
}
