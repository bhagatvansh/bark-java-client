package bark.client.util;

import bark.client.models.MoreData;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONObjectSerializer extends JsonSerializer<JSONObject> {
    @Override
    public void serialize(JSONObject jsonObject, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(jsonObject.toMap());
    }
}
