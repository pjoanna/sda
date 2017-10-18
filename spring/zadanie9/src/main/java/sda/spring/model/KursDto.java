package sda.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel(description = "Kurs")
public class KursDto {
    @ApiModelProperty(value = "Nazwa")
    @JsonProperty("name")
    @NotBlank
    private String name;
    @ApiModelProperty(value = "Data od")
    @JsonProperty("from")
    @NotNull
    private Date from;
    @ApiModelProperty(value = "Data do")
    @JsonProperty("to")
    @NotNull
    private Date to;

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

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

}
