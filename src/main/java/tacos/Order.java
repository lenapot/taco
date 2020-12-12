package tacos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "Taco_Order")
public class Order {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date placedAt;

    @NotBlank(message="Name is required")
    private String name;

    @NotBlank(message="Street is required")
    private String street;

    @NotBlank(message="City is required")
    private String city;

    @NotBlank(message="State is required")
    private String state;

    @NotBlank(message="Zip code is required")
    private String zip;

    @ManyToOne
    private User user;

//    @CreditCardNumber(message="Not a valid credit card number")
//    @NotBlank(message="Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Taco> tacos = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Order.Status status;

    public enum Status {
        PROCCESSING, DONE
    }

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    public void addDesign(Taco design, int count) {
        for (int i = 0; i < count; i++) {
            this.tacos.add(design);
        }
    }

    @PrePersist
    void placedAt(){
        this.placedAt = new Date();
    }

    @Override
    public String toString(){
        return String.format("%s %s", getId(), getName());
    }
}
