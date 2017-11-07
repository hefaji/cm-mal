package com.face.test;

import com.face.utils.HttpUtil;
import com.xiaobaidu.mall.util.JsonUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hefaji
 * @create 2017-10-25 11:00
 **/
public class AnalyzeTest {
    private static String url = "https://api-cn.faceplusplus.com/facepp/v3/face/analyze";
    private static String API_KEY="6PiHoHP8F-Z2njPYic7lH5D0FRN2ZzSy";
    private static String API_SECRET="Vz82cv1wkF2dI42MsoyHuyQTilNHa9dH";

    public static void main(String[] args) throws Exception {
        String facetoken =getFaceTokens();
        System.out.println("facetoken:"+facetoken);
        Map<String, String> map = new HashMap<>();
        map.put("api_key", API_KEY);
        map.put("api_secret", API_SECRET);
        map.put("face_tokens",facetoken);
        //map.put("return_landmark","1");
        map.put("return_attributes","gender,smiling,age,mouthstatus,beauty");

        String result = HttpUtil.doPost(url, map);
        System.out.println("result----------------" + result);

        //result----------------{"confidence": 91.932, "request_id": "1508903881,71cef499-992b-47e5-85eb-befb5f1a6545", "time_used": 434, "thresholds": {"1e-3": 62.327, "1e-5": 73.975, "1e-4": 69.101}}

    }

    public static String getFaceTokens() throws Exception {
        String url2 ="https://api-cn.faceplusplus.com/facepp/v3/detect";
        File file = new File("C:\\Users\\hefaji\\Desktop\\test222.jpg");
        Map<String,String> map = new HashMap<>();
        map.put("api_key",API_KEY);
        map.put("api_secret",API_SECRET);

        Map<String,File> map2 = new HashMap<>();
        map2.put("image_file",file);
        String result = HttpUtil.doPost(url2, map,map2);
        Map<String, Object> mapresult = JsonUtils.string2Map(result);
        List<Map<String,Object>>faces  = (List<Map<String, Object>>) mapresult.get("faces");
        Map<String,Object> m = faces.get(0);
        return (String )m.get("face_token");
    }
}
