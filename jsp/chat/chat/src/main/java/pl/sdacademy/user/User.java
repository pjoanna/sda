package pl.sdacademy.user;

import java.util.Date;

public class User {

	private int id;
	private String nickName;
	private String password;
	private Date birthDate;
	private Gender gender;
	private String desc;

	public User(int id, String nickName, String password, Date birthDate, Gender gender, String desc) {
		this.id = id;
		this.nickName = nickName;
		this.password = password;
		this.birthDate = birthDate;
		this.gender = gender;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", nickName='" + nickName + '\'' +
				", password='" + password + '\'' +
				", birthDate=" + birthDate +
				", gender=" + gender +
				", desc='" + desc + '\'' +
				'}';
	}
}
