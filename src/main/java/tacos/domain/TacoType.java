package tacos.domain;

import lombok.Data;
import tacos.domain.Ingredient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "taco_type")
public class TacoType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdat;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt(){
        this.createdat = new Date();
    }

    @Override
    public String toString(){
        return String.format("%s: %s", name, ingredients);
    }

}
