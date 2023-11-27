package bark.client.models;

//import bark.client.util.JSONObjectDeserializer;
//import bark.client.util.JSONObjectSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.json.JSONArray;
import org.json.JSONObject;
import bark.client.models.MoreData;

import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BarkLog {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int id;
    private String logTime;
    private String logLevel;
    private String serviceName;
    private String serviceInstanceName;
    private String code;
    @JsonProperty("msg")
    private String message;
//    @JsonSerialize(using = JSONObjectSerializer.class)
//    @JsonDeserialize(using = JSONObjectDeserializer.class)
//    @JsonProperty("moreData")
    private MoreData moreData;

    public BarkLog(String logLevel, String serviceName, String serviceInstanceName, String code, String message) {
        this.logLevel = logLevel;
        this.serviceName = serviceName;
        this.serviceInstanceName = serviceInstanceName;
        this.code = code;
        this.message = message;
    }

    public BarkLog() {}

    public void setLogTime(String logTime){
        this.logTime = logTime;
    }
    public String getLogLevel() {
        return logLevel;
    }
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceInstanceName() {
        return serviceInstanceName;
    }

    public void setServiceInstanceName(String serviceInstanceName) {
        this.serviceInstanceName = serviceInstanceName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MoreData getMoreData() {
        return moreData;
    }
    public void setMoreData(MoreData moreData){
        this.moreData = moreData;
    }

    public void setMoreData(String key, Object value) {
//        MoreData moreData1 = new MoreData();
//        Map<String,Object> map = new HashMap<>();
//        if(value.getClass().getSimpleName().equals("String")){
//            map.put(key, (String)value);
//        }
//        else if(value.getClass().getSimpleName().equals("Integer")){
//            map.put(key,(Integer)value);
//        }
//        else if(value.getClass().getSimpleName().equals("Boolean")){
//            map.put(key,(Boolean)value);
//        }
//        else if(value.getClass().getSimpleName().equals("Double")){
//            map.put(key,(Double)value);
//        }
//        else if(value.getClass().getSimpleName().equals("Long")){
//            map.put(key,(Long)value);
//        }
//        else{
//            map.put(key,(JSONArray)value);
//        }
//        moreData1.setJsonObject((HashMap<String, Object>) map);
//        this.moreData = moreData1;
        moreData =  MoreData.setMoreData(key,value);
    }

    public void setMoreData(Map<String,Object> data){
        MoreData moreData1 = new MoreData();
        moreData1.setStringAnyMap(data);
        this.moreData = moreData1;
    }

}
