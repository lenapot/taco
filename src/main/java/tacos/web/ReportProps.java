package tacos.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix="taco.report")
@Data
@Validated
public class ReportProps {

    private String ordersPerMonthPath="orders_per_month.jrxml";
    private String ordersCitiesPath="orders_by_cities.jrxml";
}
