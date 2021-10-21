package com.onetrillion.trip.user;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDTO {

	@NotEmpty(message = "아이디를 꼭 입력해주세요")
	private String u_id; // 아이디

	@NotEmpty(message = "비밀번호를 꼭 입력해주세요")
	@Pattern(regexp = "^[A-Za-z[0-9]]{8,15}$", message = "비밀번호는 영어 숫자 포함 8~15자리로 입력해주세요")
	private String u_pwd; // 패스워드

	@NotEmpty(message = "닉네임을 꼭 입력해주세요")
	private String u_nickName; // 이름

	@NotEmpty(message = "이메일을 꼭 입력해주세요")
	@Email(message = "이메일을 양식을 지켜주세요")
	private String u_email; // 이메일
	
//	private Date joindate;
//	
//	private int userStatus;

	public UserDTO() {
	}

	public UserDTO(@NotEmpty(message = "아이디를 꼭 입력해주세요") String u_id,
			@NotEmpty(message = "비밀번호를 꼭 입력해주세요") @Pattern(regexp = "^[A-Za-z[0-9]]{8,15}$", message = "비밀번호는 영어 숫자 포함 8~15자리로 입력해주세요") String u_pwd,
			@NotEmpty(message = "닉네임을 꼭 입력해주세요") String u_nickName,
			@NotEmpty(message = "이메일을 꼭 입력해주세요") @Email(message = "이메일을 양식을 지켜주세요") String u_email) {
		super();
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_nickName = u_nickName;
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

	public String getU_nickName() {
		return u_nickName;
	}

	public void setU_nickName(String u_nickName) {
		this.u_nickName = u_nickName;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	@Override
	public String toString() {
		return "UserDTO [u_id=" + u_id + ", u_pwd=" + u_pwd + ", u_nickName=" + u_nickName + ", u_email=" + u_email
				+ "]";
	}

		

}