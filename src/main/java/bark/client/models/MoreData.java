package bark.client.models;

//import bark.client.util.JSONObjectDeserializer;
//import bark.client.util.JSONObjectSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MoreData {

    public boolean hasTopLevelArray;
    public boolean isValid;
//    @JsonSerialize(using = JSONObjectSerializer.class)
//    @JsonDeserialize(using = JSONObjectDeserializer.class)
    @JsonProperty("stringAnyMap")
    public Map<String,Object> stringAnyMap;
  //  JSONObject jsonObject = new JSONObject();

    public MoreData(){};

    public static MoreData EmptyNotNotJsonObject(){
        MoreData moreData = new MoreData();
        moreData.setStringAnyMap(new HashMap<String,Object>());
        moreData.setIsValid(true);
        moreData.setHasTopLevelArray(false);
        return moreData;
    }

    public static MoreData setMoreData(String key, Object value) {
        MoreData moreData1 = new MoreData();
        Map<String,Object> map = new HashMap<>();
        switch (value.getClass().getSimpleName()) {
            case "String":
                map.put(key, (String) value);
                break;
            case "Integer":
                map.put(key, (Integer) value);
                break;
            case "Boolean":
                map.put(key, (Boolean) value);
                break;
            case "Double":
                map.put(key, (Double) value);
                break;
            case "Long":
                map.put(key, (Long) value);
                break;
            default:
                map.put(key, (JSONArray) value);
                break;
        }

        moreData1.setStringAnyMap(map);
        moreData1.setIsValid(true);
        moreData1.setHasTopLevelArray(true);
        return moreData1;
    }

    public void setStringAnyMap(Map<String,Object> stringAnyMap){
        this.stringAnyMap = stringAnyMap;
    }

    public void setHasTopLevelArray(boolean topLevelArray){
        this.hasTopLevelArray = topLevelArray;
    }

    public void setIsValid(boolean isValid){
        this.isValid = isValid;
    }

    public Map<String,Object> getStringAnyMap(){
        return stringAnyMap;
    }

//    public void setMoreData(MoreData moreData) {
//
//
//        this.moreData = moreData;
//    }


//    @Override
//    public String toString() {
//        return "MoreData{" +
//                "hasTopLevelArray=" + hasTopLevelArray +
//                ", isValid=" + isValid +
//                ", stringAnyMap=" + stringAnyMap +
//                '}';
//    }
}
