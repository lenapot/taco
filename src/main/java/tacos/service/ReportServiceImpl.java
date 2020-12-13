package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.OrderVo;
import tacos.data.OrderRepository;

import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @Override
    public List<OrderVo> getOrdersPerMonth() {
        List<OrderVo> orders = orderRepository.getOrdersByMonth();
        orders.forEach(order -> {
            String tacosStr = orderService.getTacosWithCountInStr(order.getId());
            order.setTacos(tacosStr);
        });
        return orders;
    }

    @Override
    public List<Map<String, Integer>> getOrderCountByCities() {
        List<Map<String, Integer>> ordersCountByCities = orderRepository.getOrdersCountByCities();
        return ordersCountByCities;
    }


}
