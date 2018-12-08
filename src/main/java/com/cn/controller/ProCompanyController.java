package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.ProCompany;
import com.cn.service.ComProStuService;
import com.cn.service.ProCompanyService;
import com.cn.utils.ResponseMsg;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (ProCompany)表控制层
 *
 * @author kai
 * @since 2018-11-25 22:26:26
 */
@CrossOrigin
@RestController
@RequestMapping(value="proCompany",produces = "text/html;charset=utf-8")
public class ProCompanyController {
    /**
     * 服务对象
     */
    @Resource
    private ProCompanyService proCompanyService;

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
        return gson.toJson(this.proCompanyService.queryById(id));

    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping(value = "nocheck",method = RequestMethod.GET)
    public String all(Integer draw) {
        List<ProCompany> proCompanyList=this.proCompanyService.all(false);
        JSONObject jsonObject=new JSONObject();
        if(proCompanyList.size()!=0){
//            return ResponseMsg.success(proCompanyList);
            jsonObject.put("msg",1);
            jsonObject.put("data",proCompanyList);
            jsonObject.put("draw",draw);
//            返回的数据记录数
            jsonObject.put("recordsTotal",proCompanyList.size());
//            过滤后的记录数
            jsonObject.put("recordsFiltered",proCompanyList.size());
            return jsonObject.toString();
        }else{
            return ResponseMsg.fail();
        }

    }

    /**
     * 企业添加项目
     * @param request 前台提交
     * @return 结果
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String insertPro(HttpServletRequest request){
        ProCompany proCompany=new ProCompany();
        proCompany.setFkCId(request.getParameter("fkCId"));
        proCompany.setcName(request.getParameter("cName"));
        proCompany.setCpName(request.getParameter("cpName"));
        proCompany.setCpReward(Double.parseDouble(request.getParameter("cpReward")));
        proCompany.setCpDemand(request.getParameter("cpDemand"));
        //开始时间
        String startdate=request.getParameter("cpStartT");
        java.sql.Date startTime=java.sql.Date.valueOf(startdate);
        proCompany.setCpStartT(startTime);
        //结束时间
        String enddate=request.getParameter("cpEndT");
        java.sql.Date endTime=java.sql.Date.valueOf(enddate);
        proCompany.setCpEndT(endTime);
        proCompany.setCpDetail(request.getParameter("cpDetail"));
        ProCompany proCompany1=this.proCompanyService.insert(proCompany);
        JSONObject jsonObject=new JSONObject();
        if (proCompany1!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",proCompany1);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }

    /**
     * 获取自己的全部项目
     * @param fkcid 企业号
     * @return 数据
     */
    @RequestMapping(value = "getByCid",method = RequestMethod.GET)
    public String queryPro(@RequestParam String fkcid){
        List<ProCompany> list=this.proCompanyService.queryProAndCommentByCId(fkcid);
        JSONObject jsonObject=new JSONObject();
        if(list.size()!=0){
            jsonObject.put("msg",1);
            jsonObject.put("data",list);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }

    /**
     * 通过项目名或者项目开始时间、结束时间动态查询
     * @param request 前台数据
     * @return 查询结果
     */
    @RequestMapping(value = "queryByPro",method = RequestMethod.GET)
    public String queryByPro(HttpServletRequest request){
        ProCompany proCompany=new ProCompany();
        proCompany.setFkCId(request.getParameter("fkCId"));
        proCompany.setCpName(request.getParameter("cpName"));
        //开始时间
        String startT=request.getParameter("cpStartT");
        if(startT!=""){
            java.sql.Date sData=java.sql.Date.valueOf(startT);
            proCompany.setCpStartT(sData);
        }
        //结束时间
        String endT=request.getParameter("cpEndT");
        if(endT!=""){
            java.sql.Date eData=java.sql.Date.valueOf(endT);
            proCompany.setCpEndT(eData);
        }
        System.out.println(proCompany.toString());

        List<ProCompany> proCompany1=this.proCompanyService.queryAll(proCompany);
        System.out.println(proCompany1.toString());
//        JSONObject jsonObject=new JSONObject();
        if(proCompany1.size()!=0){
            return ResponseMsg.success(proCompany1);
//            jsonObject.put("msg",1);
//            jsonObject.put("data",proCompany1);
//            return jsonObject.toString();
        }else{
            return ResponseMsg.fail();
//            jsonObject.put("msg",0);
//            return jsonObject.toString();
        }
    }

    /**
     * 通过学号查询学生竞标的项目信息
     * @param fkSId 学号
     * @return 信息
     */
    @RequestMapping(value = "getStuPro",method = RequestMethod.POST)
    public String queryByPid(String fkSId){
        // 查询所有项目ID
        List<Integer> pids=this.comProStuService.queryPidBySid(fkSId);
        JSONObject jsonObject=new JSONObject();
        if(pids.size()!=0){
//            存放查询到的项目
            List<ProCompany> proCompanyLis=new ArrayList<ProCompany>();
            ProCompany proCompany;
            for(Integer pid:pids){
                proCompany=this.proCompanyService.queryById(pid);
                proCompanyLis.add(proCompany);
            }
            jsonObject.put("msg",1);
            jsonObject.put("data",proCompanyLis);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }


    /**
     * 根据企业号审核项目
     * @param id 项目号
     * @return 审核信息
     */
    @RequestMapping(value = "updateFlag",method = RequestMethod.POST)
    public String updatePro( Integer id){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sTime=simpleDateFormat.format(date);
        System.out.println(sTime);
        Timestamp pubDate=java.sql.Timestamp.valueOf(sTime);
        System.out.println(pubDate);
        int i=this.proCompanyService.updateProFlag(pubDate,id);
        JSONObject jsonObject=new JSONObject();
        if(i>=1){
            jsonObject.put("msg",1);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }

}