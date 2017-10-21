package sda.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@ApiModel("Citizen")
public class CitizenDto {

    @ApiModelProperty("id - klucz sztuczny")
    private Long id;
    @NotBlank
    @ApiModelProperty("Nazwa obywatela")
    private String name;

    @JsonIgnore
    @ApiModelProperty("lista bohaterów")
    public List<SuperHero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<SuperHero> heroes) {
        this.heroes = heroes;
    }

    @ApiModelProperty("Lista bohaterów")
    private List<SuperHero> heroes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
