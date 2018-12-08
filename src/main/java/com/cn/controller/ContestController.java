package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.Contest;
import com.cn.service.ContestService;
import com.cn.utils.UploadUtil;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * (Contest)表控制层
 *
 * @author kai
 * @since 2018-11-25 22:09:33
 */
@CrossOrigin
@RestController
@RequestMapping(value="contest",produces = "text/html;charset=utf-8")
public class ContestController {
    /**
     * 服务对象
     */
    @Resource
    private ContestService contestService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.contestService.queryById(id));

    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("/")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.contestService.all());
    }

    /**
     * 学生增添竞赛
     * @param request 表单
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String insertContest(HttpServletRequest request, @RequestParam(value = "cProve") MultipartFile file) throws IOException {
        Contest contest=new Contest();
        contest.setFkSId(request.getParameter("fkSId"));
        contest.setCName(request.getParameter("cName"));
        String sDate=request.getParameter("cDate");
        //字符型时间转换成sql时间
        java.sql.Date cData=java.sql.Date.valueOf(sDate);
        contest.setCDate(cData);
        contest.setCGrade(request.getParameter("cGrade"));
        contest.setCLever(request.getParameter("cLever"));
        //保存图片
        String imgName= UploadUtil.imgUpload(file);
        contest.setCProve(imgName);
        Contest contest1=this.contestService.insert(contest);
        System.out.println(contest1);
        JSONObject jsonObject=new JSONObject();
        if(contest!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",contest1);
            return jsonObject.toString();
        }
        jsonObject.put("msg",0);
        return jsonObject.toString();
    }

    /**
     * 查询自己的竞赛
     * @param fkSId 学号
     * @return 竞赛对象
     */
    @RequestMapping(value = "getBysid",method = RequestMethod.GET)
    public String queryContest(@RequestParam String fkSId){
        List<Contest> list=this.contestService.queryBySid(fkSId);
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

}