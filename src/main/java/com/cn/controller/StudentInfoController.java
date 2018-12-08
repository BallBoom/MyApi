package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.StudentInfo;
import com.cn.service.StudentInfoService;
import com.cn.utils.ResponseMsg;
import com.cn.utils.UploadUtil;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

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
     * 查询所有未审核的学生
     *
     * @return 全部数据
     */
    @RequestMapping(value = "nocheck",method = RequestMethod.GET)
    public String all( Integer draw) {
        List<StudentInfo> studentInfoList=this.studentInfoService.all(false);
        JSONObject jsonObject=new JSONObject();
        if (studentInfoList.size()!=0){
            jsonObject.put("msg",1);
            jsonObject.put("data",studentInfoList);
            jsonObject.put("draw",draw);
//            返回的数据记录数
            jsonObject.put("recordsTotal",studentInfoList.size());
//            过滤后的记录数
            jsonObject.put("recordsFiltered",studentInfoList.size());
            return jsonObject.toString();
//            return ResponseMsg.success(studentInfoList);
        }else {
            jsonObject.put("msg",0);
            return jsonObject.toString();
//            return ResponseMsg.fail();
        }

    }

    /**
     * 通过手机号查询学生
     * @param phone 手机号 从cookie中获取
     * @return 学生信息
     * 存在 1，则获取学生信息 student
     * 不存在 0，则补全信息
     */
    @RequestMapping(value = "student",method = RequestMethod.GET)
    public String queryStudnet(@RequestParam String phone){
        StudentInfo studentInfo=this.studentInfoService.queryStudent(phone);
        JSONObject jsonObject=new JSONObject();
        if(studentInfo!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",studentInfo);
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
     * 成功 1 返回数据
     * 失败 0
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String insertStudent(HttpServletRequest request, @RequestParam("sProve") MultipartFile file) throws IOException {
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
        // 保存图片
        String imgName= UploadUtil.imgUpload(file);
        studentInfo.setsProve(imgName);
        System.out.println(imgName);
        StudentInfo studentInfo1=this.studentInfoService.insert(studentInfo);
        if(studentInfo1!=null){
            return ResponseMsg.success(studentInfo1);
//            jsonObject.put("msg",1);
//            jsonObject.put("data",studentInfo1);
//            return jsonObject.toString();
        }else{
            return ResponseMsg.fail();
//            jsonObject.put("msg",0);
//            return jsonObject.toString();
        }
    }


    /**
     * 获取学生全部信息
     * @param sid 学号
     * @return json信息
     */
    @RequestMapping(value = "myinfo",method = RequestMethod.POST)
    public String queryALLStuInfo(@RequestParam String sid){
        StudentInfo studentInfo=this.studentInfoService.queryAllInfo(sid);
        System.out.println(studentInfo);
//        JSONObject jsonObject=new JSONObject();
        if(studentInfo!=null){
            return ResponseMsg.success(studentInfo);
//            jsonObject.put("msg",1);
//            jsonObject.put("data",studentInfo);
//            return jsonObject.toString();
        }else{
//            jsonObject.put("msg",0);
//            return jsonObject.toString();
            return ResponseMsg.fail();
        }
    }


    /**
     * 管理员审核学生信息
     * @param sid 学号
     * @return 更改信息
     */
    @RequestMapping(value = "updateFlag",method = RequestMethod.POST)
    public String updateStudent(@RequestParam String sid){
        int i=this.studentInfoService.updateStudent(sid);
        JSONObject jsonObject=new JSONObject();
        if(i>=1){
            jsonObject.put("msg",1);
            return jsonObject.toString();
        }else {
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }

}