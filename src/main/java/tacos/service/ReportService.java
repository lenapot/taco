package tacos.service;


import tacos.OrderVo;

import java.util.List;
import java.util.Map;

public interface ReportService {

    List<OrderVo> getOrdersPerMonth();
    List<Map<String, Integer>> getOrderCountByCities();
}
