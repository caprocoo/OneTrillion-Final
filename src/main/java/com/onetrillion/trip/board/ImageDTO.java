package com.onetrillion.trip.board;

public class ImageDTO {
	
	private int pd_seq;	//상품 번호 - primary key
	
	private String image01;
	private String image02;
	private String image03;
	private String image04;
	private String image05;
	
	public ImageDTO() {}
	
	
	public ImageDTO(int pd_seq, String image01, String image02, String image03, String image04, String image05) {
		this.pd_seq = pd_seq;
		this.image01 = image01;
		this.image02 = image02;
		this.image03 = image03;
		this.image04 = image04;
		this.image05 = image05;
	}


	public int getPd_seq() {
		return pd_seq;
	}
	public void setPd_seq(int pd_seq) {
		this.pd_seq = pd_seq;
	}
	public String getImage01() {
		return image01;
	}
	public void setImage01(String image01) {
		this.image01 = image01;
	}
	public String getImage02() {
		return image02;
	}
	public void setImage02(String image02) {
		this.image02 = image02;
	}
	public String getImage03() {
		return image03;
	}
	public void setImage03(String image03) {
		this.image03 = image03;
	}
	public String getImage04() {
		return image04;
	}
	public void setImage04(String image04) {
		this.image04 = image04;
	}
	public String getImage05() {
		return image05;
	}
	public void setImage05(String image05) {
		this.image05 = image05;
	}


	@Override
	public String toString() {
		return "ImageDTO [pd_seq=" + pd_seq + ", image01=" + image01 + ", image02=" + image02 + ", image03=" + image03
				+ ", image04=" + image04 + ", image05=" + image05 + "]";
	}

}
