package tacos.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix="taco.report.orderspercities")
@Data
@Validated
public class OrderPerCitiesReportProps extends ReportProps{

    private String sourcePath = "orders_by_cities.jrxml";
    private String reportName = "ordersCountByCities.pdf";
}
