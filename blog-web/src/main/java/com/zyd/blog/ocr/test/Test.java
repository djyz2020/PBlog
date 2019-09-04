package com.zyd.blog.ocr.test;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @date 2018年5月7日 上午9:14:41
 * Description: 测试类
 */
public class Test {
    //设置APPID/AK/SK
    public static final String APP_ID = "15432144";
    public static final String API_KEY = "cHM1hkTxaBsyoxzEddgcfq5f";
    public static final String SECRET_KEY = "tfOaDqGANbG6aKx36EZPe5gPEk5ScXUk";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        String imgFilePath = "D:\\eclipse_javaee\\springcloud\\ocr_project\\image2Text\\src\\main\\resources\\static\\img\\test.png";
        JSONObject res = client.basicGeneral(imgFilePath, options);
        System.out.println(res);
        JSONArray words = res.getJSONArray("words_result");
        Iterator<Object> it = words.iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            JSONObject ob = (JSONObject) it.next();
            sb.append(ob.getString("words"));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
