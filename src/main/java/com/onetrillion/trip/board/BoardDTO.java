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
	private String pd_content; // 상품내용
	private int mylist; // 인원 수
	private int good; // 인원 수
	private String pd_nation;
	private String pd_location;
	private String pd_land;
	private int adult_num;
	private int teenager_num;
	private int pet_num;
	private int adult_price;
	private int teenager_price;
	private int pet_price;

	public BoardDTO() {
	}

	public BoardDTO(int pd_seq, String pd_name, int pd_price, String pd_keyword, LocalDate pd_startDate,
			LocalDate pd_endDate, int pd_cnt, String pd_theme, String pd_people, String pd_image, String pd_content,
			int mylist, int good, String pd_nation, String pd_location, String pd_land, int adult_num, int teenager_num,
			int pet_num, int adult_price, int teenager_price, int pet_price) {
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
		this.pd_content = pd_content;
		this.mylist = mylist;
		this.good = good;
		this.pd_nation = pd_nation;
		this.pd_location = pd_location;
		this.pd_land = pd_land;
		this.adult_num = adult_num;
		this.teenager_num = teenager_num;
		this.pet_num = pet_num;
		this.adult_price = adult_price;
		this.teenager_price = teenager_price;
		this.pet_price = pet_price;
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

	public String getPd_content() {
		return pd_content;
	}

	public void setPd_content(String pd_content) {
		this.pd_content = pd_content;
	}

	public int getMylist() {
		return mylist;
	}

	public void setMylist(int mylist) {
		this.mylist = mylist;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public String getPd_nation() {
		return pd_nation;
	}

	public void setPd_nation(String pd_nation) {
		this.pd_nation = pd_nation;
	}

	public String getPd_location() {
		return pd_location;
	}

	public void setPd_location(String pd_location) {
		this.pd_location = pd_location;
	}

	public String getPd_land() {
		return pd_land;
	}

	public void setPd_land(String pd_land) {
		this.pd_land = pd_land;
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

	@Override
	public String toString() {
		return "BoardDTO [pd_seq=" + pd_seq + ", pd_name=" + pd_name + ", pd_price=" + pd_price + ", pd_keyword="
				+ pd_keyword + ", pd_startDate=" + pd_startDate + ", pd_endDate=" + pd_endDate + ", pd_cnt=" + pd_cnt
				+ ", pd_theme=" + pd_theme + ", pd_people=" + pd_people + ", pd_image=" + pd_image + ", pd_content="
				+ pd_content + ", mylist=" + mylist + ", good=" + good + ", pd_nation=" + pd_nation + ", pd_location="
				+ pd_location + ", pd_land=" + pd_land + ", adult_num=" + adult_num + ", teenager_num=" + teenager_num
				+ ", pet_num=" + pet_num + ", adult_price=" + adult_price + ", teenager_price=" + teenager_price
				+ ", pet_price=" + pet_price + "]";
	}


}
