package com.face.test;

import com.face.utils.HttpUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hefaji
 * @create 2017-10-25 11:00
 **/
public class ComPareTest {
    private static String url = "https://api-cn.faceplusplus.com/facepp/v3/compare";
    private static String API_KEY="6PiHoHP8F-Z2njPYic7lH5D0FRN2ZzSy";
    private static String API_SECRET="Vz82cv1wkF2dI42MsoyHuyQTilNHa9dH";

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\hefaji\\Desktop\\test2.jpg");
        Map<String, String> map = new HashMap<>();
        map.put("api_key", API_KEY);
        map.put("api_secret", API_SECRET);
        map.put("face_token1", "2c5f8f62b10de697cb3c5281884e7262");
        map.put("face_token2", "c80e1afc984790ecf33d1dce331bb55e");


        String result = HttpUtil.doPost(url, map);
        System.out.println("result----------------" + result);

        //result----------------{"confidence": 91.932, "request_id": "1508903881,71cef499-992b-47e5-85eb-befb5f1a6545", "time_used": 434, "thresholds": {"1e-3": 62.327, "1e-5": 73.975, "1e-4": 69.101}}

    }
}
