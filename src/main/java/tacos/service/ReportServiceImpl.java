package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.Order;
import tacos.Taco;
import tacos.data.OrderRepository;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Map<String, Object>> getOrdersPerMonth() {
        List<Order> orders = (List<Order>) orderRepository.findAll();

        List<Map<String, Object>> ordersPerMonth = new ArrayList<>();

        orders.stream()
                .sorted((o1, o2) -> o2.getPlacedAt().compareTo(o1.getPlacedAt()))
                .forEach(order -> {
                    Map<String, Object> orderMap = new HashMap<>();
                    orderMap.put("id", order.getId());
                    orderMap.put("name", order.getName());
                    orderMap.put("address", String.format("%s, %s, %s", order.getState(), order.getCity(), order.getStreet()));
                    SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", Locale.US);
                    String dateForReport = sdf.format(order.getPlacedAt());
                    orderMap.put("month", dateForReport);
                    StringBuilder sb = new StringBuilder();
                    order.getTacos().stream()
                            .map(Taco::toString)
                            .forEach(s -> sb.append(s).append("<br>"));
                    orderMap.put("tacos",sb.toString());

                    ordersPerMonth.add(orderMap);
                });
        return ordersPerMonth;

    }

    @Override
    public List<Map<String, Integer>> getOrdersCountByCities() {
        List<Map<String, Integer>> ordersCountByCities = orderRepository.getOrdersCountByCities();
        return ordersCountByCities;
    }
}
