package com.onetrillion.trip.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {

	@NotEmpty // not null 조건
	@Size(min = 8, max = 15) // 8~15 알파벳 1 , 숫자 1씩) // 정규표현식으로 제한을 둬야함 빡쌔다 ....
	@Pattern(regexp="^[A-Za-z0-9]{8,15}$")
	private String u_id; // 아이디

	// (regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}")

	@Size(min = 8, max = 15) // 8~15 알파벳 1 , 숫자 1씩
	@NotEmpty // not null 조건 //
	@Pattern(regexp="^[A-Za-z0-9]{8,15}$")
	private String u_pwd; // 패스워드

	@NotEmpty // not null 조건
	private String u_name; // 이름

	@NotEmpty // not null 조건
	private String u_address1; // 주소

	@NotEmpty
	private String u_address2; // 주소 2

	@NotEmpty
	private String zipcode; // 우편번호

	@NotEmpty
	private String u_tel; // 전화번호

	@NotEmpty
	@Email
	private String u_email; // 이메일

	public UserDTO() {
	}

	public UserDTO(@NotEmpty @Size(min = 8, max = 15) @Pattern(regexp = "^[A-Za-z0-9]{8,15}$") String u_id,
	         @Size(min = 8, max = 15) @NotEmpty @Pattern(regexp = "^[A-Za-z0-9]{8,15}$") String u_pwd,
	         @NotEmpty String u_name, @NotEmpty String u_address1, @NotEmpty String u_address2, @NotEmpty String zipcode,
	         @NotEmpty String u_tel, @NotEmpty @Email String u_email) {
	      this.u_id = u_id;
	      this.u_pwd = u_pwd;
	      this.u_name = u_name;
	      this.u_address1 = u_address1;
	      this.u_address2 = u_address2;
	      this.zipcode = zipcode;
	      this.u_tel = u_tel;
	      this.u_email = u_email;
	   }
	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_address1() {
		return u_address1;
	}

	public void setU_address1(String u_address1) {
		this.u_address1 = u_address1;
	}

	public String getU_address2() {
		return u_address2;
	}

	public void setU_address2(String u_address2) {
		this.u_address2 = u_address2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getU_tel() {
		return u_tel;
	}

	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	@Override
	public String toString() {
		return "UserDTO [u_id=" + u_id + ", u_pwd=" + u_pwd + ", u_name=" + u_name + ", u_address1=" + u_address1
				+ ", u_address2=" + u_address2 + ", zipcode=" + zipcode + ", u_tel=" + u_tel + ", u_email=" + u_email
				+ "]";
	}

}