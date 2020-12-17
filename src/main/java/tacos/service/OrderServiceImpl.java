package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tacos.domain.Order;
import tacos.vo.OrderVo;
import tacos.domain.User;
import tacos.repo.OrderRepository;
import tacos.props.OrderProps;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderProps props;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Page<OrderVo> getOrdersByUser(User user, int pageNum) {
        PageRequest pageable = PageRequest.of(pageNum - 1, props.getPageSize());
        Page<OrderVo> orderPage = orderRepository.findByUserOrderByPlacedAtDesc(user, pageable);
        orderPage.forEach(order -> {
            String tacosStr = getTacosWithCountInStr(order.getId());
            order.setTacos(tacosStr);
        });
        return orderPage;
    }

    @Override
    public List<Order> getOrdersByUser(User user) {
        List<Order> orderList = orderRepository.findByUserOrderByPlacedAtDesc(user);
        return orderList;
    }

    @Override
    public Page<OrderVo> getAllOrders(int pageNum) {
        PageRequest pageable = PageRequest.of(pageNum - 1, props.getPageSize());
        Page<OrderVo> orders = orderRepository.findAllByOrderByPlacedAtDesc(pageable);
        orders.forEach(order -> {
            String tacosStr = getTacosWithCountInStr(order.getId());
            order.setTacos(tacosStr);
        });
        return orders;
    }

    @Override
    //todo: Optional правильно обработать
    public Order getOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElseGet(() -> optionalOrder.orElseThrow(RuntimeException::new));
    }

    @Override
    public void updateOrderStatus(Order order) {
        Order existing = orderRepository.findById(order.getId()).get();
        existing.setStatus(order.getStatus());
        orderRepository.save(existing);
    }

    @Override
    public String getTacosWithCountInStr(Long orderId) {
        List<Map<String, Object>> tacos =
                orderRepository.getTacosCountByType(orderId);

        StringBuilder tacosSb = new StringBuilder();
        tacos.forEach(taco ->
                tacosSb.append(String.format("%s - %d pcs", taco.get("tacotype"), taco.get("count")))
                        .append("\n")
        );
        return tacosSb.toString();
    }
}
