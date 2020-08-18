package tacos.security;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import tacos.Order;
import tacos.data.OrderRepository;
import tacos.service.OrderService;
import tacos.service.ReportService;
import tacos.web.OrderProps;
import tacos.web.ReportProps;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin/report")
@Slf4j
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportProps props;

    @GetMapping(value = "/ordersPerMonth")
    @ResponseBody
    public void showReportOrdersPerMonth(final HttpServletResponse response) throws JRException, IOException {
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"ordersPerMonth.pdf\""));

        OutputStream out = response.getOutputStream();
        List<Map<String, Object>> ordersPerMonth = reportService.getOrdersPerMonth();

        JRBeanCollectionDataSource itemJRBean = new JRBeanCollectionDataSource(ordersPerMonth);
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("orders", itemJRBean);

        File file = ResourceUtils.getFile(String.format("classpath:%s", props.getOrdersPerMonthPath()));

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfStream(jasperPrint, out);
    }

    @GetMapping(value = "/cities")
    @ResponseBody
    public void showReportOrdersCountByCities(final HttpServletResponse response) throws JRException, IOException {
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"ordersCountByCities.pdf\""));

        OutputStream out = response.getOutputStream();
        List<Map<String, Integer>> countByCities = reportService.getOrdersCountByCities();

        JRBeanCollectionDataSource itemJRBean = new JRBeanCollectionDataSource(countByCities);

        File file = ResourceUtils.getFile(String.format("classpath:%s", props.getOrdersCitiesPath()));

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, itemJRBean);

        JasperExportManager.exportReportToPdfStream(jasperPrint, out);
    }

}