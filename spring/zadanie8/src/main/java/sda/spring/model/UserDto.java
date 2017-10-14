package sda.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

@ApiModel(description = "Uzytkownik")
public class UserDto {

	@NotBlank
	@ApiModelProperty(value = "Login")
	@JsonProperty("username")
	private String username;
	@ApiModelProperty(value = "Haslo")
	@JsonProperty("password")
	@NotBlank
	private String password;
	@ApiModelProperty(value = "Imie")
	@JsonProperty("firstname")
	@NotBlank
	private String firstname;
	@ApiModelProperty(value = "Nazwisko")
	@JsonProperty("lastname")
	@NotBlank
	private String lastname;
	@ApiModelProperty(value = "Email")
	@JsonProperty("email")
	@NotBlank
	private String email;
	@NotBlank
	@ApiModelProperty(value = "Adres")
	@JsonProperty("address")
	private String address;
	@Min(1)
	@ApiModelProperty(value = "telefon")
	@JsonProperty("phone")
	
	private int phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}