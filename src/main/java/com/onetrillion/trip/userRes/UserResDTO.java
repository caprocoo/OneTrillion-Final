package com.onetrillion.trip.userRes;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class UserResDTO {

	private int ures_seq; // 예약 번호 - primary key
	private int pd_seq; // 상품 번호 - FK
	private String pd_name; // 상품명
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate pd_startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate pd_endDate;
	private int adult_num;
	private int teenager_num;
	private int pet_num;
	private int adult_price;
	private int teenager_price;
	private int pet_price;
	private int res_price; // 총 금액
	private int res_people; // 총 인원 수
	private String res_name; // 예약자명
	private String res_birth; // 예약자 생년월일
	private String res_email; // 예약자 이메일
	private String res_comment; // 요청사항
	private String u_id; // 회원 아이디 -FK
	private String res_phone;
	private String reply_check;
	
	
	public UserResDTO() {
	}



	public UserResDTO(int ures_seq, int pd_seq, String pd_name, LocalDate pd_startDate, LocalDate pd_endDate,
			int adult_num, int teenager_num, int pet_num, int adult_price, int teenager_price, int pet_price,
			int res_price, int res_people, String res_name, String res_birth, String res_email, String res_comment,
			String u_id, String res_phone, String reply_check) {
		this.ures_seq = ures_seq;
		this.pd_seq = pd_seq;
		this.pd_name = pd_name;
		this.pd_startDate = pd_startDate;
		this.pd_endDate = pd_endDate;
		this.adult_num = adult_num;
		this.teenager_num = teenager_num;
		this.pet_num = pet_num;
		this.adult_price = adult_price;
		this.teenager_price = teenager_price;
		this.pet_price = pet_price;
		this.res_price = res_price;
		this.res_people = res_people;
		this.res_name = res_name;
		this.res_birth = res_birth;
		this.res_email = res_email;
		this.res_comment = res_comment;
		this.u_id = u_id;
		this.res_phone = res_phone;
		this.reply_check = reply_check;
	}



	public int getUres_seq() {
		return ures_seq;
	}

	public void setUres_seq(int ures_seq) {
		this.ures_seq = ures_seq;
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

	public int getRes_price() {
		return res_price;
	}

	public void setRes_price(int res_price) {
		this.res_price = res_price;
	}

	public int getRes_people() {
		return res_people;
	}

	public void setRes_people(int res_people) {
		this.res_people = res_people;
	}

	public String getRes_name() {
		return res_name;
	}

	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}

	public String getRes_birth() {
		return res_birth;
	}

	public void setRes_birth(String res_birth) {
		this.res_birth = res_birth;
	}

	public String getRes_email() {
		return res_email;
	}

	public void setRes_email(String res_email) {
		this.res_email = res_email;
	}

	public String getRes_comment() {
		return res_comment;
	}

	public void setRes_comment(String res_comment) {
		this.res_comment = res_comment;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getRes_phone() {
		return res_phone;
	}

	public void setRes_phone(String res_phone) {
		this.res_phone = res_phone;
	}

	public String getReply_check() {
		return reply_check;
	}
	public void setReply_check(String reply_check) {
		this.reply_check = reply_check;
	}
	@Override
	public String toString() {
		return "UserResDTO [ures_seq=" + ures_seq + ", pd_seq=" + pd_seq + ", pd_name=" + pd_name + ", pd_startDate="
				+ pd_startDate + ", pd_endDate=" + pd_endDate + ", adult_num=" + adult_num + ", teenager_num="
				+ teenager_num + ", pet_num=" + pet_num + ", adult_price=" + adult_price + ", teenager_price="
				+ teenager_price + ", pet_price=" + pet_price + ", res_price=" + res_price + ", res_people="
				+ res_people + ", res_name=" + res_name + ", res_birth=" + res_birth + ", res_email=" + res_email
				+ ", res_comment=" + res_comment + ", u_id=" + u_id + ", res_phone=" + res_phone + ", reply_check="
				+ reply_check + "]";
	}
}
