package com.onetrillion.trip.board;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardDTO {

	private int pd_seq; // 상품 번호 - primary key
	private String pd_name; // 상품명
	private int pd_price; // 상품가격
	private String pd_keyword; // 상품 키워드 - 지도
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate pd_startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate pd_endDate;
	private int pd_cnt; // 조회수
	private String pd_theme; // 상품 테마
	private String pd_people; // 인원
	private String pd_image;
	private String pd_content1; // 상품내용1
	private String pd_location;
	private int adult_num;
	private int teenager_num;
	private int pet_num;
	private int adult_price;
	private int teenager_price;
	private int pet_price;
	private String pd_content2; // 상품내용2
	private String pd_content3; // 상품내용3
	private String pd_content4; // 상품내용4
	private String pd_content5; // 상품내용5
	private String pd_contentImage1; // 상품내용이미지1
	private String pd_contentImage2; // 상품내용이미지2
	private String pd_contentImage3; // 상품내용이미지3
	private String pd_contentImage4; // 상품내용이미지4
	private String pd_contentImage5; // 상품내용이미지5
	
	
	public BoardDTO() {}
	
	public BoardDTO(int pd_seq, String pd_name, int pd_price, String pd_keyword, LocalDate pd_startDate,
			LocalDate pd_endDate, int pd_cnt, String pd_theme, String pd_people, String pd_image, String pd_content1,
			String pd_location, int adult_num, int teenager_num, int pet_num, int adult_price, int teenager_price,
			int pet_price, String pd_content2, String pd_content3, String pd_content4, String pd_content5,
			String pd_contentImage1, String pd_contentImage2, String pd_contentImage3, String pd_contentImage4,
			String pd_contentImage5) {
		this.pd_seq = pd_seq;
		this.pd_name = pd_name;
		this.pd_price = pd_price;
		this.pd_keyword = pd_keyword;
		this.pd_startDate = pd_startDate;
		this.pd_endDate = pd_endDate;
		this.pd_cnt = pd_cnt;
		this.pd_theme = pd_theme;
		this.pd_people = pd_people;
		this.pd_image = pd_image;
		this.pd_content1 = pd_content1;
		this.pd_location = pd_location;
		this.adult_num = adult_num;
		this.teenager_num = teenager_num;
		this.pet_num = pet_num;
		this.adult_price = adult_price;
		this.teenager_price = teenager_price;
		this.pet_price = pet_price;
		this.pd_content2 = pd_content2;
		this.pd_content3 = pd_content3;
		this.pd_content4 = pd_content4;
		this.pd_content5 = pd_content5;
		this.pd_contentImage1 = pd_contentImage1;
		this.pd_contentImage2 = pd_contentImage2;
		this.pd_contentImage3 = pd_contentImage3;
		this.pd_contentImage4 = pd_contentImage4;
		this.pd_contentImage5 = pd_contentImage5;
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
	public int getPd_price() {
		return pd_price;
	}
	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}
	public String getPd_keyword() {
		return pd_keyword;
	}
	public void setPd_keyword(String pd_keyword) {
		this.pd_keyword = pd_keyword;
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
	public int getPd_cnt() {
		return pd_cnt;
	}
	public void setPd_cnt(int pd_cnt) {
		this.pd_cnt = pd_cnt;
	}
	public String getPd_theme() {
		return pd_theme;
	}
	public void setPd_theme(String pd_theme) {
		this.pd_theme = pd_theme;
	}
	public String getPd_people() {
		return pd_people;
	}
	public void setPd_people(String pd_people) {
		this.pd_people = pd_people;
	}
	public String getPd_image() {
		return pd_image;
	}
	public void setPd_image(String pd_image) {
		this.pd_image = pd_image;
	}
	public String getPd_content1() {
		return pd_content1;
	}
	public void setPd_content1(String pd_content1) {
		this.pd_content1 = pd_content1;
	}
	public String getPd_location() {
		return pd_location;
	}
	public void setPd_location(String pd_location) {
		this.pd_location = pd_location;
	}
	public int getAdult_num() {
		return adult_num;
	}
	public void setAdult_num(int adult_num) {
		this.adult_num = adult_num;
	}
	public int getTeenager_num() {
		return teenager_num;
	}
	public void setTeenager_num(int teenager_num) {
		this.teenager_num = teenager_num;
	}
	public int getPet_num() {
		return pet_num;
	}
	public void setPet_num(int pet_num) {
		this.pet_num = pet_num;
	}
	public int getAdult_price() {
		return adult_price;
	}
	public void setAdult_price(int adult_price) {
		this.adult_price = adult_price;
	}
	public int getTeenager_price() {
		return teenager_price;
	}
	public void setTeenager_price(int teenager_price) {
		this.teenager_price = teenager_price;
	}
	public int getPet_price() {
		return pet_price;
	}
	public void setPet_price(int pet_price) {
		this.pet_price = pet_price;
	}
	public String getPd_content2() {
		return pd_content2;
	}
	public void setPd_content2(String pd_content2) {
		this.pd_content2 = pd_content2;
	}
	public String getPd_content3() {
		return pd_content3;
	}
	public void setPd_content3(String pd_content3) {
		this.pd_content3 = pd_content3;
	}
	public String getPd_content4() {
		return pd_content4;
	}
	public void setPd_content4(String pd_content4) {
		this.pd_content4 = pd_content4;
	}
	public String getPd_content5() {
		return pd_content5;
	}
	public void setPd_content5(String pd_content5) {
		this.pd_content5 = pd_content5;
	}
	public String getPd_contentImage1() {
		return pd_contentImage1;
	}
	public void setPd_contentImage1(String pd_contentImage1) {
		this.pd_contentImage1 = pd_contentImage1;
	}
	public String getPd_contentImage2() {
		return pd_contentImage2;
	}
	public void setPd_contentImage2(String pd_contentImage2) {
		this.pd_contentImage2 = pd_contentImage2;
	}
	public String getPd_contentImage3() {
		return pd_contentImage3;
	}
	public void setPd_contentImage3(String pd_contentImage3) {
		this.pd_contentImage3 = pd_contentImage3;
	}
	public String getPd_contentImage4() {
		return pd_contentImage4;
	}
	public void setPd_contentImage4(String pd_contentImage4) {
		this.pd_contentImage4 = pd_contentImage4;
	}
	public String getPd_contentImage5() {
		return pd_contentImage5;
	}
	public void setPd_contentImage5(String pd_contentImage5) {
		this.pd_contentImage5 = pd_contentImage5;
	}
	@Override
	public String toString() {
		return "BoardDTO [pd_seq=" + pd_seq + ", pd_name=" + pd_name + ", pd_price=" + pd_price + ", pd_keyword="
				+ pd_keyword + ", pd_startDate=" + pd_startDate + ", pd_endDate=" + pd_endDate + ", pd_cnt=" + pd_cnt
				+ ", pd_theme=" + pd_theme + ", pd_people=" + pd_people + ", pd_image=" + pd_image + ", pd_content1="
				+ pd_content1 + ", pd_location=" + pd_location + ", adult_num=" + adult_num + ", teenager_num="
				+ teenager_num + ", pet_num=" + pet_num + ", adult_price=" + adult_price + ", teenager_price="
				+ teenager_price + ", pet_price=" + pet_price + ", pd_content2=" + pd_content2 + ", pd_content3="
				+ pd_content3 + ", pd_content4=" + pd_content4 + ", pd_content5=" + pd_content5 + ", pd_contentImage1="
				+ pd_contentImage1 + ", pd_contentImage2=" + pd_contentImage2 + ", pd_contentImage3=" + pd_contentImage3
				+ ", pd_contentImage4=" + pd_contentImage4 + ", pd_contentImage5=" + pd_contentImage5 + "]";
	}
	
	
	


}
