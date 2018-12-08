package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.Jobinfo;
import com.cn.service.JobinfoService;
import com.cn.utils.ResponseMsg;
import com.cn.utils.UploadUtil;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Jobinfo)表控制层
 *
 * @author kai
 * @since 2018-11-25 22:21:11
 */
@CrossOrigin
@RestController
@RequestMapping(value="jobinfo",produces = "text/html;charset=utf-8")
public class JobinfoController {
    /**
     * 服务对象
     */
    @Resource
    private JobinfoService jobinfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @RequestMapping("selectOne/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.jobinfoService.queryById(id));

    }
    
    
    /**
     * 管理员查询未审核的招聘信息
     *
     * @return 全部数据
     */
    @RequestMapping(value = "nocheck",method = RequestMethod.GET)
    public String all(Integer draw) {
        List<Jobinfo> jobinfoList=this.jobinfoService.all(false);
        JSONObject jsonObject=new JSONObject();
        if(jobinfoList.size()!=0){
            jsonObject.put("draw",draw);
            jsonObject.put("data",jobinfoList);
            jsonObject.put("recordsTotal",jobinfoList.size());
            jsonObject.put("recordsFiltered",jobinfoList.size());
            return jsonObject.toString();
        }else{
            return ResponseMsg.fail();
        }
    }

    /**
     * 通过企业号获取招聘信息
     * @param fkcid 企业号
     * @return 招聘信息
     */
    @RequestMapping(value = "getByCid",method = RequestMethod.GET)
    public String queryJob(@RequestParam String fkcid){
        List<Jobinfo> list=this.jobinfoService.queryByCId(fkcid);
        JSONObject jsonObject=new JSONObject();
        if(list!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",list);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }


    /**
     * 企业添加招聘信息
     * @param request 表单
     * @param file 图片
     * @return 添加信息
     * @throws IOException 输入流异常
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String insertJob(HttpServletRequest request, @RequestParam(value = "jOthers")MultipartFile file) throws IOException {
        Jobinfo jobinfo=new Jobinfo();
        jobinfo.setFkCId(request.getParameter("fkCId"));
        jobinfo.setcName(request.getParameter("cName"));
        //开始时间
        String sTimes=request.getParameter("jSTime");
        java.sql.Date sTime=java.sql.Date.valueOf(sTimes);
        jobinfo.setJSTime(sTime);
        //结束时间
        String eTimes=request.getParameter("jETime");
        java.sql.Date eTime=java.sql.Date.valueOf(eTimes);
        jobinfo.setJETime(eTime);
        jobinfo.setjPost(request.getParameter("jPost"));
        jobinfo.setJPerson(request.getParameter("jPerson"));
        jobinfo.setJPhone(request.getParameter("jPhone"));
        // 保存图片
        String imgNmae= UploadUtil.imgUpload(file);
        jobinfo.setJOthers(imgNmae);
        Jobinfo jobinfo1=this.jobinfoService.insert(jobinfo);
        JSONObject jsonObject=new JSONObject();
        if(jobinfo1!=null){
            jsonObject.put("msg",1);
            return jobinfo.toString();
        }else{
            jsonObject.put("msg",0);
            return jobinfo.toString();
        }
    }

    /**
     * 招聘信息的多条件查询
     * @param request 前台信息
     * @return 招聘信息
     */
    @RequestMapping(value = "getJobByJob",method = RequestMethod.GET)
    public String queryJob(HttpServletRequest request){
        Jobinfo jobinfo=new Jobinfo();
        jobinfo.setFkCId(request.getParameter("fkCId"));
        jobinfo.setjPost(request.getParameter("jPost"));
        String sTime=request.getParameter("jSTime");
        if(sTime!=""){
            java.sql.Date sDate=java.sql.Date.valueOf(sTime);
            jobinfo.setJSTime(sDate);
        }
        String eTime=request.getParameter("jETime");
        if(eTime!=""){
            java.sql.Date eDate=java.sql.Date.valueOf(eTime);
            jobinfo.setJETime(eDate);
        }
        System.out.println(jobinfo.toString());
        List<Jobinfo> jobinfos=this.jobinfoService.queryAllByJob(jobinfo);
        if(jobinfos.size()!=0){
            return ResponseMsg.success(jobinfos);
        }else{
            return ResponseMsg.fail();
        }
    }

    /**
     * 管理员通过企业招聘
     * @param id 招聘ID
     * @return 修改信息
     */
    @RequestMapping(value = "updateFlag",method = RequestMethod.POST)
    public String updateJobInfo(@RequestParam Integer id){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate=simpleDateFormat.format(date);
        int i=this.jobinfoService.updateJobFlag(Timestamp.valueOf(nowDate),id);
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