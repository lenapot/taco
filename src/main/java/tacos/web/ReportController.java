package tacos.web;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tacos.vo.OrderVo;
import tacos.props.OrderPerCitiesReportProps;
import tacos.service.ReportService;
import tacos.utils.ReportUtils;
import tacos.props.OrderPerMonthReportProps;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/admin/report")
@Slf4j
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private OrderPerMonthReportProps orderPerMonthReportProps;

    @Autowired
    private OrderPerCitiesReportProps orderPerCitiesReportProps;

    @GetMapping(value = "/ordersPerMonth")
    @ResponseBody
    public void showReportOrdersPerMonth(final HttpServletResponse response) throws JRException, IOException {
        List<OrderVo> ordersPerMonth = reportService.getOrdersPerMonth();
        JRBeanCollectionDataSource itemJRBean = new JRBeanCollectionDataSource(ordersPerMonth);
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("orders", itemJRBean);

        JasperPrint jasperPrint = ReportUtils.getJasperPrint(orderPerMonthReportProps, parameters, new JREmptyDataSource());
        ReportUtils.createReport(response, orderPerMonthReportProps, jasperPrint, "PDF");
    }

    @GetMapping(value = "/cities")
    @ResponseBody
    public void showReportOrdersCountByCities(final HttpServletResponse response) throws JRException, IOException {
        List<Map<String, Integer>> countByCities = reportService.getOrderCountByCities();
        JRBeanCollectionDataSource itemJRBean = new JRBeanCollectionDataSource(countByCities);

        JasperPrint jasperPrint = ReportUtils.getJasperPrint(orderPerCitiesReportProps, null, itemJRBean);
        ReportUtils.createReport(response, orderPerCitiesReportProps, jasperPrint, "PDF");
    }

}