package tacos.service;


import java.util.List;
import java.util.Map;

public interface ReportService {

    List<Map<String, Object>> getOrdersPerMonth();
    List<Map<String, Integer>> getOrdersCountByCities();
}
