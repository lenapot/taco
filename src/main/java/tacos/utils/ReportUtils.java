package tacos.utils;

import net.sf.jasperreports.engine.*;
import org.springframework.util.ResourceUtils;
import tacos.props.ReportProps;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class ReportUtils {

    public static void createReport(HttpServletResponse response, ReportProps props,
                                    JasperPrint jasperPrint, String type) throws IOException, JRException {
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition",
                String.format("attachment; filename=\"%s\"", props.getReportName()));

        OutputStream out = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, out);
    }

    public static JasperPrint getJasperPrint(ReportProps props,
                                             Map<String, Object> parameters,
                                             JRDataSource dataSource) throws IOException, JRException {

        File file = ResourceUtils.getFile(String.format("classpath:%s", props.getSourcePath()));

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return jasperPrint;
    }
}
