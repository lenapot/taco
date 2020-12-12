package tacos.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
public class ReportProps {

    private String sourcePath;
    private String reportName;
}
