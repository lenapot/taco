package tacos;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "taco")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TacoType tacotype;

    @JoinColumn(name="order_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;



}
