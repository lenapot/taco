package tacos.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix="taco.report.orderspermonth")
@Data
@Validated
public class OrderPerMonthReportProps extends ReportProps{

    private String sourcePath = "orders_per_month.jrxml";
    private String reportName = "ordersPerMonth.pdf";
}
