package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.StudentInfo;
import com.cn.service.StudentInfoService;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (StudentInfo)表控制层
 *
 * @author kai
 * @since 2018-11-23 00:14:44
 */
@CrossOrigin
@RestController
@RequestMapping(value="studentInfo",produces = "text/html;charset=utf-8")
public class StudentInfoController {
    /**
     * 服务对象
     */
    @Resource
    private StudentInfoService studentInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.studentInfoService.queryById(id));
    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("/")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.studentInfoService.all());
    }

    /**
     *
     * @param phone 手机号 从session中获取
     * @return 学生信息
     * 存在 1，则获取学生信息 student
     * 不存在 0，则补全信息
     */
    @RequestMapping(value = "Student",method = RequestMethod.GET)
    public String queryStudnet(@RequestParam String phone){
        StudentInfo studentInfo=this.studentInfoService.queryStudent(phone);
        JSONObject jsonObject=new JSONObject();
        Gson gson=new Gson();
        if(studentInfo!=null){

            jsonObject.put("msg",1);
            jsonObject.put("student",studentInfo);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }


    /**
     * 学生完善信息
     * @param request 表单提交
     * @return 插入结果
     * 成功 1
     * 失败 0
     */
    @RequestMapping(value = "Student",method = RequestMethod.POST)
    public String insertStudent(HttpServletRequest request){
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setUPhone(request.getParameter("uPhone"));
        studentInfo.setSId(request.getParameter("sId"));
        studentInfo.setSName(request.getParameter("sName"));
        studentInfo.setSSex(request.getParameter("sSex"));
        studentInfo.setSSchool(request.getParameter("sSchool"));
        studentInfo.setSProfession(request.getParameter("sProfession"));
        studentInfo.setSClass(request.getParameter("sClass"));
        studentInfo.setSRemarks(request.getParameter("sRemarks"));
        studentInfo.setSStatus(request.getParameter("sStatus"));
        studentInfo.setSExpertise(request.getParameter("sExpertise"));
        studentInfo.setsProve(request.getParameter("sProve"));
        int i=this.studentInfoService.insert(studentInfo);
        JSONObject jsonObject=new JSONObject();
        if(i>0){
            jsonObject.put("msg",1);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }



}