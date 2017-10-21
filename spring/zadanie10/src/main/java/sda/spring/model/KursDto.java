package sda.spring.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Kurs")
public class KursDto {
	@ApiModelProperty(value = "Nazwa")
	@JsonProperty("name")
	@NotBlank
	private String name;
	@ApiModelProperty(value = "Data od", dataType="java.util.Date")
	@JsonProperty("from")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate from;
	@ApiModelProperty(value = "Data do", dataType="java.util.Date")
	@JsonProperty("to")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate to;
	
	@ApiModelProperty(value = "Maksymalna liczba uczestnikow")
	@JsonProperty("maxParticipants")
	@Min(1)
	private int maxParticipants;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

}
