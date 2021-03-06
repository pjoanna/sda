package sda.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@ApiModel("SuperHero")
public class SuperHeroDto {
    @ApiModelProperty("id - klucz sztuczny")
    @JsonIgnore
    private Long id;
    @NotBlank
    @ApiModelProperty("Nazwa bohatera")
    private String name;
    @JsonIgnore
    @ApiModelProperty("Lista obywateli")
    private List<Citizen> citizens;

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
