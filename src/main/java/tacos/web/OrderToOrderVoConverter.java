package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.Ingredient;
import tacos.Order;
import tacos.OrderVo;
import tacos.data.IngredientRepository;

import java.util.Optional;

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
