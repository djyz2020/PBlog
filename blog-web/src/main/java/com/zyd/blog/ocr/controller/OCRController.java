package com.zyd.blog.ocr.controller;

import com.google.gson.Gson;
import com.zyd.blog.ocr.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haibozhang on 2019/1/16.
 */

@Controller
public class OCRController {
    public static Logger logger = LoggerFactory.getLogger(OCRController.class);
    public static Gson gson = new Gson();

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/ocr")
    public String index(){
        return "ocr";
    }

    @RequestMapping("/image2Text")
    @ResponseBody
    public String image2Text(@RequestParam("action")String action, @RequestParam("base64")String base64){
        String imageText = "";   //识别后的文本
        if(action != null && action.equals(action)) {
            String imgFilePath = new File("./test.jpg").getAbsolutePath();
            // 在ajax传参过程中base64中的+会替换为空格
            String result = pictureService.getPicture(base64.replace(" ", "+"), imgFilePath);
            if(!StringUtils.isEmpty(result)) {
                imageText = pictureService.getText(result);
                logger.info("imageText=" + imageText);
                return format(200, imageText);
            }else{
                return format(200, "图片中不包含文字");
            }
        }
        return format(200, "识别异常");
    }

    public String format(int code, String data){
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("data", data);
        return gson.toJson(map);
    }

}
