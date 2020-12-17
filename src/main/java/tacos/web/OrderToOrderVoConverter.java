package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.domain.Order;
import tacos.vo.OrderVo;

@Component
public class OrderToOrderVoConverter implements Converter<Order, OrderVo> {

    @Autowired
    public OrderToOrderVoConverter( ) {
    }

    @Override
    public OrderVo convert(Order order) {
        return new OrderVo(order);
    }

}
