package com.face.test;

import com.face.utils.HttpUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hefaji
 * @create 2017-10-25 11:00
 **/
public class DetectTest {
    private static String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
    private static String API_KEY="6PiHoHP8F-Z2njPYic7lH5D0FRN2ZzSy";
    private static String API_SECRET="Vz82cv1wkF2dI42MsoyHuyQTilNHa9dH";

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\hefaji\\Desktop\\test55.jpg");
        Map<String,String> map = new HashMap<>();
        map.put("api_key",API_KEY);
        map.put("api_secret",API_SECRET);

        Map<String,File> map2 = new HashMap<>();
        map2.put("image_file",file);
        String result = HttpUtil.doPost(url, map,map2);
        System.out.println("result----------------"+result);

        //test{"image_id": "tCUuUQ/zMBNc+yV2o3lVmw==", "request_id": "1508901835,badc20ce-4d68-4728-9a3a-8544df03df9d", "time_used": 114, "faces": [{"face_rectangle": {"width": 65, "top": 52, "left": 75, "height": 65}, "face_token": "a6fa0ff5389c0643ff3ba43f6c3eeb15"}]}

        //test1 {"image_id": "o/CLl6LAn5MJdD9j/j0EcA==", "request_id": "1508903548,d473f964-0371-4879-b893-c3e0223cd1c4", "time_used": 321, "faces": [{"face_rectangle": {"width": 282, "top": 563, "left": 484, "height": 282}, "face_token": "1342ea8c673ae62a97707ef7c7022bc1"}]}

        //test2 {"image_id": "cWAUj3pBoHQsjSWM/oG2FA==", "request_id": "1508903570,227d206b-00bb-4ace-b7be-fc75fa371d5a", "time_used": 249, "faces": [{"face_rectangle": {"width": 175, "top": 899, "left": 654, "height": 175}, "face_token": "8e1ce6bea7f69fb6362e74b6c3866553"}]}

        //test3 {"image_id": "byTSI9My42wlloi3LTrwZA==", "request_id": "1508904525,5ba3cd9a-a056-42c7-9dd9-4b1710d5ea35", "time_used": 433, "faces": [{"face_rectangle": {"width": 274, "top": 590, "left": 130, "height": 274}, "face_token": "cb86c4b6ea1828b947866ba916b4f88f"}, {"face_rectangle": {"width": 181, "top": 970, "left": 562, "height": 181}, "face_token": "c80e1afc984790ecf33d1dce331bb55e"}]}

        //test4 {"image_id": "fpXVEoHVtkrVrcTnuKYnHg==", "request_id": "1508904605,23a8f967-6ba6-4dde-9f9c-f0918e416c6d", "time_used": 297, "faces": [{"face_rectangle": {"width": 290, "top": 650, "left": 746, "height": 290}, "face_token": "faf605d34b847faa0360138bee6a8a8d"}]}

        //test5 {"image_id": "lcFpQm+II2xJ+/87a1FViA==", "request_id": "1508904848,620f6f28-a6c2-4d1b-b6b7-216ac8af16ee", "time_used": 344, "faces": [{"face_rectangle": {"width": 94, "top": 549, "left": 493, "height": 94}, "face_token": "2c5f8f62b10de697cb3c5281884e7262"}]}
    }


}
