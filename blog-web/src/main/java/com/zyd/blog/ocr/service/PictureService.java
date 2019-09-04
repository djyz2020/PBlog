package com.zyd.blog.ocr.service;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

@Service
public class PictureService{
    public static Logger logger = LoggerFactory.getLogger(PictureService.class);

    @Value("${APP_ID}")
    private String APP_ID;
    @Value("${API_KEY}")
    private String API_KEY;
    @Value("${SECRET_KEY}")
    private String SECRET_KEY;

    // 字符串转换成图片
    public static String getPicture(String str, String imgFilePath) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        //使用 BASE64Decoder对象报错，查看博客：https://blog.csdn.net/u011514810/article/details/72725398
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream os = null;
        File file = new File(imgFilePath);
        try {
            byte[] bytes = decoder.decodeBuffer(str);
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            os = new FileOutputStream(file);
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            try {
                if(os != null){
                    os.flush();
                    os.close();
                }
                if(file.exists()){

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imgFilePath;
    }

    // Description: 获取图片中的文字
    public String getText(String imgFilePath) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        JSONObject res = client.basicGeneral(imgFilePath, options);
        JSONArray words = res.getJSONArray("words_result");
        Iterator<Object> it = words.iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            JSONObject ob = (JSONObject) it.next();
            logger.info(ob.toString());
            sb.append(ob.getString("words"));
        }
        return sb.toString();
    }

}
