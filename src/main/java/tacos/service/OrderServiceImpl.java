package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tacos.Order;
import tacos.User;
import tacos.data.OrderRepository;
import tacos.web.OrderProps;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderProps props;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Page<Order> getOrdersByUser(User user, int pageNum) {
        PageRequest pageable = PageRequest.of(pageNum - 1, props.getPageSize());
        Page<Order> orderPage = orderRepository.findByUserOrderByPlacedAtDesc(user, pageable);
        return orderPage;
    }

    @Override
    public List<Order> getOrdersByUser(User user) {
        Page<Order> orderPage = orderRepository.findByUserOrderByPlacedAtDesc(user, Pageable.unpaged());
        return orderPage.getContent();
    }

    @Override
    public Page<Order> getAllOrders(int pageNum) {
        PageRequest pageable = PageRequest.of(pageNum - 1, props.getPageSize());
        return orderRepository.findAllByOrderByPlacedAtDesc(pageable);
    }

    @Override
    //todo: Optional правильно обработать
    public Order getOrder(long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.isPresent() ?
                optionalOrder.get() : optionalOrder.orElseThrow(RuntimeException::new);
    }

    @Override
    public void updateOrderStatus(Order order) {
        Order existing = orderRepository.findById(order.getId()).get();
        existing.setStatus(order.getStatus());
        orderRepository.save(existing);
    }
}
