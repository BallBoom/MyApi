package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.CompanyInfo;
import com.cn.service.CompanyInfoService;
import com.cn.utils.UploadUtil;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * (CompanyInfo)表控制层
 *
 * @author kai
 * @since 2018-11-24 23:46:19
 */
@CrossOrigin
@RestController
@RequestMapping(value="companyInfo",produces = "text/html;charset=utf-8")
public class CompanyInfoController {
    /**
     * 服务对象
     */
    @Resource
    private CompanyInfoService companyInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.companyInfoService.queryById(id));
    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("/")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.companyInfoService.all());
    }

    /**
     * 查询企业信息
     * @param phone 手机号
     * @return 结果
     */
    @RequestMapping(value = "company",method = RequestMethod.GET)
    public String queryCompany(@RequestParam String phone){
        CompanyInfo companyInfo=this.companyInfoService.queryCompany(phone);
        JSONObject jsonObject=new JSONObject();
        if(companyInfo!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",companyInfo);
            return jsonObject.toString();
        }else {
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }

    /**
     * 企业信息完善
     * @param request 表单信息
     * @return 插入结果
     * 1 插入成功 返回企业信息
     * 0 插入失败
     */
     @RequestMapping(value = "company",method = RequestMethod.POST)
     public String insertCompany(@RequestParam(value = "cPhoto") MultipartFile file,HttpServletRequest request) throws IOException {
        JSONObject jsonObject=new JSONObject();
        CompanyInfo companyInfo=new CompanyInfo();
        companyInfo.setUPhone(request.getParameter("uPhone"));
        companyInfo.setCId(request.getParameter("cId"));
        companyInfo.setCName(request.getParameter("cName"));
        companyInfo.setCContact(request.getParameter("cContact"));
        companyInfo.setCPhone(request.getParameter("cPhone"));
        companyInfo.setCEmail(request.getParameter("cEmail"));
        companyInfo.setCQq(request.getParameter("cQq"));
        companyInfo.setCBusiness(request.getParameter("cBusiness"));
        companyInfo.setCTechnology(request.getParameter("cTechnology"));
        companyInfo.setCProduct(request.getParameter("cProduct"));
        companyInfo.setCAddress(request.getParameter("cAddress"));
        companyInfo.setCPostCode(request.getParameter("cPostCode"));

        // 图片文件名
        String filename=UploadUtil.imgUpload(file);
        System.out.println(filename);
        companyInfo.setCPhoto(filename);
        companyInfo.setCWeb(request.getParameter("cWeb"));
        companyInfo.setCPlant(request.getParameter("cPlant"));
        System.out.println(companyInfo.toString());
        CompanyInfo companyInfo1=this.companyInfoService.insert(companyInfo);
        if(companyInfo1!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",companyInfo1);

            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }

}