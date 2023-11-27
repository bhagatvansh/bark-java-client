package bark.client.util;

import bark.client.models.BarkLog;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLogFormatter extends Formatter {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    BarkLog barkLog;
    @Override
    public String format(LogRecord record) {
        barkLog= (BarkLog) record.getParameters()[0];
        String logTime = dateFormat.format(new Date());
        String logLevel = record.getLevel().getName();
        String serviceName = barkLog.getServiceName();
        String serviceInstanceName = barkLog.getServiceInstanceName();
        String code = barkLog.getCode();
        String logMessage = formatMessage(record);

        return logTime + " | " + logLevel + " | " + serviceName + " | "
                + serviceInstanceName + " | " + code + " | " + logMessage + "\n";
    }

}
