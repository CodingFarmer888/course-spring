package vo;

import java.util.Arrays;

public class UserVo {

	private String nickname;
	
	private String phone;
	
	private String[] hobby;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "UserVo [nickname=" + nickname + ", phone=" + phone + ", hobby=" + Arrays.toString(hobby) + "]";
	}
	
}
