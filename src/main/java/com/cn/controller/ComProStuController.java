package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.ComProStu;
import com.cn.service.ComProStuService;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (ComProStu)表控制层
 *
 * @author kai
 * @since 2018-11-28 15:54:35
 */
@CrossOrigin
@RestController
@RequestMapping(value="comProStu",produces = "text/html;charset=utf-8")
public class ComProStuController {
    /**
     * 服务对象
     */
    @Resource
    private ComProStuService comProStuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.comProStuService.queryById(id));

    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("all")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.comProStuService.all());
         
    }

    /**
     * 企业项目ID查询学生竞标信息
     * @param pId 项目ID
     * @return 竞标的所有学生
     */
    @RequestMapping(value = "getBypId",method = RequestMethod.GET)
    public String queryStuPro(@RequestParam String pId){
        List<ComProStu> comProStuList=this.comProStuService.queryStudentBypId(pId);
        JSONObject jsonObject=new JSONObject();
        if(comProStuList.size()!=0){
            jsonObject.put("msg",1);
            jsonObject.put("data",comProStuList);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            jsonObject.put("data","暂无学生竞标");
            return jsonObject.toString();
        }
    }

}