package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.StuLetter;
import com.cn.service.StuLetterService;
import com.cn.utils.ResponseMsg;
import com.cn.utils.UploadUtil;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * (StuLetter)表控制层
 *
 * @author kai
 * @since 2018-12-02 15:40:08
 */
@CrossOrigin
@RestController
@RequestMapping(value="stuLetter",produces = "text/html;charset=utf-8")
public class StuLetterController {
    /**
     * 服务对象
     */
    @Resource
    private StuLetterService stuLetterService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.stuLetterService.queryById(id));

    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("all")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.stuLetterService.all());
    }

    /**
     * 学生添加推荐信
     * @param fkSId 学号
     * @param file 图片
     * @return 插入信息
     * @throws IOException 输入流异常
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String insertLet(String fkSId,@RequestParam(value = "letPhoto") MultipartFile file) throws IOException {
        StuLetter stuLetter=new StuLetter();
        stuLetter.setFkSId(fkSId);
//        图片名字
        String imgName= UploadUtil.imgUpload(file);
        stuLetter.setLetPhoto(imgName);
        StuLetter stuLetter1=this.stuLetterService.insert(stuLetter);
        JSONObject jsonObject=new JSONObject();
        if(stuLetter1!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",stuLetter1);
            return jsonObject.toString();
        }
        jsonObject.put("msg",0);
        return jsonObject.toString();
    }


    @RequestMapping(value = "getBySid",method = RequestMethod.GET)
    public String queryLet(String fkSId){
        StuLetter stuLetter=this.stuLetterService.queryLetter(fkSId);
        System.out.println(stuLetter.toString());
//        JSONObject jsonObject=new JSONObject();
        if (stuLetter!=null){
//            jsonObject.put("msg",1);
//            jsonObject.put("data",stuLetter);
//            return jsonObject.toString();
           return ResponseMsg.success(stuLetter);
        }else return ResponseMsg.fail();
//        jsonObject.put("msg",0);
//        return jsonObject.toString();

    }


}