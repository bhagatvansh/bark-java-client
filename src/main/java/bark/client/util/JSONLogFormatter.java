package bark.client.util;

import bark.client.models.BarkLog;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class JSONLogFormatter extends Formatter {

    private BarkLog barkLog;
    private final ObjectMapper objectMapper = new ObjectMapper();

    String jsonString;
    @Override
    public String format(LogRecord record){
        barkLog = (BarkLog) record.getParameters()[0];
        try {
            jsonString = objectMapper.writeValueAsString(barkLog);
        } catch (JsonProcessingException e) {
            System.out.println("E#1NDC8I - Error occurred while marshalling for JSON logging.");
        }

        return jsonString + "\n";
    }
}
