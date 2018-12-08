package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.Practice;
import com.cn.service.PracticeService;
import com.cn.utils.UploadUtil;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * (Practice)表控制层
 *
 * @author kai
 * @since 2018-11-25 22:10:43
 */
@CrossOrigin
@RestController
@RequestMapping(value="practice",produces = "text/html;charset=utf-8")
public class PracticeController {
    /**
     * 服务对象
     */
    @Resource
    private PracticeService practiceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.practiceService.queryById(id));

    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("all")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.practiceService.all());
         
    }


    /**
     * 添加社会实践信息
     * @param request 表单信息
     * @param file 图片文件
     * @return 增加信息
     * @throws IOException 输入流异常
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String insertPra(HttpServletRequest request, @RequestParam("pProve")MultipartFile file) throws IOException {
        Practice practice=new Practice();
        practice.setFkSId(request.getParameter("fkSId"));
        practice.setPName(request.getParameter("pName"));
        practice.setPRole(request.getParameter("pRole"));
        practice.setPContent(request.getParameter("pContent"));
        practice.setPScore(request.getParameter("pScore"));
        // 上传图片
        String imgName= UploadUtil.imgUpload(file);
        practice.setPProve(imgName);
        Practice practice1=this.practiceService.insert(practice);
        JSONObject jsonObject=new JSONObject();
        if(practice1!=null){
            jsonObject.put("msg",1);
            jsonObject.put("item",practice1);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }


    @RequestMapping(value ="getBysid",method = RequestMethod.GET)
    public String queryPractice(@RequestParam String fkSId){
        List<Practice> practiceList=this.practiceService.queryBysId(fkSId);
        JSONObject jsonObject=new JSONObject();
        if(practiceList!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",practiceList);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }
}