package tacos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

@AllArgsConstructor
@Getter@Setter
public class OrderVo {

    Long id;
    String name;
    String address;
    String month;
    String tacos;
    Date placedAt;
    Order.Status status;

    public OrderVo(Long id, String name, String address, Date placedAt){
        this.id = id;
        this.name = name;
        this.address = address;
        LocalDate localDate = placedAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.month = new DateFormatSymbols(Locale.CANADA).getMonths()[localDate.getMonthValue()-1];
    }

    public OrderVo(Order order){
        this.id = order.getId();
        this.name = order.getName();
        this.placedAt = order.getPlacedAt();
        this.status = order.getStatus();
    }


}
