package com.onetrillion.trip.wishlist;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

// 10/09 16:00 이희연 WishlistDTO 추가
public class WishlistDTO {

	private int w_seq; // PK
	private int pd_seq; // FK
	private String pd_name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate pd_startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate pd_endDate;
	private int pd_price;
	private String pd_image;
	private String u_id; // FK
	
	public WishlistDTO() {
	}

	public WishlistDTO(int w_seq, int pd_seq, String pd_name, LocalDate pd_startDate, LocalDate pd_endDate,
			int pd_price, String pd_image, String u_id) {
		this.w_seq = w_seq;
		this.pd_seq = pd_seq;
		this.pd_name = pd_name;
		this.pd_startDate = pd_startDate;
		this.pd_endDate = pd_endDate;
		this.pd_price = pd_price;
		this.pd_image = pd_image;
		this.u_id = u_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getW_seq() {
		return w_seq;
	}

	public void setW_seq(int w_seq) {
		this.w_seq = w_seq;
	}

	public int getPd_seq() {
		return pd_seq;
	}

	public void setPd_seq(int pd_seq) {
		this.pd_seq = pd_seq;
	}

	public String getPd_name() {
		return pd_name;
	}

	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}

	public LocalDate getPd_startDate() {
		return pd_startDate;
	}

	public void setPd_startDate(LocalDate pd_startDate) {
		this.pd_startDate = pd_startDate;
	}

	public LocalDate getPd_endDate() {
		return pd_endDate;
	}

	public void setPd_endDate(LocalDate pd_endDate) {
		this.pd_endDate = pd_endDate;
	}

	public int getPd_price() {
		return pd_price;
	}

	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}

	public String getPd_image() {
		return pd_image;
	}

	public void setPd_image(String pd_image) {
		this.pd_image = pd_image;
	}

	@Override
	public String toString() {
		return "WishlistDTO [w_seq=" + w_seq + ", pd_seq=" + pd_seq + ", pd_name=" + pd_name + ", pd_startDate="
				+ pd_startDate + ", pd_endDate=" + pd_endDate + ", pd_price=" + pd_price + ", pd_image=" + pd_image
				+ ", u_id=" + u_id + "]";
	}


	
}