package com.face.test;

import com.face.utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hefaji
 * @create 2017-10-25 11:26
 **/
public class FaceSetTest {


    private static String API_KEY="6PiHoHP8F-Z2njPYic7lH5D0FRN2ZzSy";
    private static String API_SECRET="Vz82cv1wkF2dI42MsoyHuyQTilNHa9dH";

    public static String createFaceSet(){
        String url = "https://api-cn.faceplusplus.com/facepp/v3/faceset/create";
        Map<String,String> map = new HashMap<>();
        map.put("api_key",API_KEY);
        map.put("api_secret",API_SECRET);

        String result = HttpUtil.doPost(url, map);
        return result;
        //{"faceset_token": "8929c51353afce54def3b8bb387f272a", "time_used": 95, "face_count": 0, "face_added": 0, "request_id": "1508902142,51f7c699-8e5e-4d18-aef8-f4b463d4013d", "outer_id": "", "failure_detail": []}
    }


    public static String addFace(){
        String url = "https://api-cn.faceplusplus.com/facepp/v3/faceset/addface";
        Map<String,String> map = new HashMap<>();
        map.put("api_key",API_KEY);
        map.put("api_secret",API_SECRET);
        map.put("faceset_token","8929c51353afce54def3b8bb387f272a");
        map.put("face_tokens","2c5f8f62b10de697cb3c5281884e7262");

        String result = HttpUtil.doPost(url, map);
        return result;

        //{"faceset_token": "8929c51353afce54def3b8bb387f272a", "time_used": 487, "face_count": 1, "face_added": 1, "request_id": "1508902544,d42d0456-73af-4b77-b735-973a7975a8e1", "outer_id": "", "failure_detail": []}
    }

    public static void main(String[] args) {

        //System.out.println(createFaceSet());

        System.out.println(addFace());
    }
}
