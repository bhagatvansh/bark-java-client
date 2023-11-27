package bark.client.examples;

import bark.client.constants.Constants;
import bark.client.models.BarkLog;
import bark.client.models.Config;
import bark.client.models.MoreData;
import bark.client.util.StandardLogFormatter;
import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.FileHandler;

import static bark.client.models.Config.NewLoggerBarkClient;

public class Client_ClientLoggerOnly {
    public static void main(String[] args) throws IOException {
        Config logConf = NewLoggerBarkClient(Constants.Info);
      //  FileHandler fileHandler = new FileHandler("output_logger.log", true);
      //  fileHandler.setFormatter(new StandardLogFormatter());
        logConf.setConsoleHandler();
        logConf.setJSONFormatter();

        logConf.Info("Hello Info Logger Only");
//       logConf.Debug("Hello Debug Logger Only");
//        logConf.Panic("Hello Panic Logger Only");
//        logConf.Alert("A#13VM7 - Hello Alert Logger Only");
//        logConf.Warn("Hello Warn Logger Only");
//        logConf.Error("Hello Error Logger Only");
//        logConf.Notice("Hello Notice Logger Only");
//        logConf.Default("Hello Default Logger only");
//        logConf.Println("Hello println Logger only");
       BarkLog log = new BarkLog("PANIC","Rawservice","Rawinstance","00001","Raw logger");
   //     MoreData moreData = new MoreData();
    //    JSONObject jsonObject = new JSONObject();
     //   jsonObject.put("fileName","ClientLoggerOnly");
      //  moreData.setJsonObject(jsonObject);
        log.setMoreData("fileName","ClientLoggerOnly");
        logConf.Raw(log);
    }
}
