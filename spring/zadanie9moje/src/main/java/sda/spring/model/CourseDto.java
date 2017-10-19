package sda.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.Date;

@ApiModel(description = "Kurs")
public class CourseDto{


    @NotBlank
    @ApiModelProperty(value = "nazwa")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "Data rozpoczęcia")
    @JsonProperty("start")
    private Date start;

    @ApiModelProperty(value = "Data zakończenia")
    @JsonProperty("end")
    private Date end;


    @ApiModelProperty(value = "maksymalna liczba uczestników")
    @JsonProperty("max participants")
    private int maxParticipants;

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}
