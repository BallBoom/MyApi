package com.cn.controller;

import com.cn.entity.ComJobStu;
import com.cn.service.ComJobStuService;
import com.cn.utils.ResponseMsg;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ComJobStu)表控制层
 *
 * @author kai
 * @since 2018-11-29 11:55:23
 */
@CrossOrigin
@RestController
@RequestMapping(value="comJobStu",produces = "text/html;charset=utf-8")
public class ComJobStuController {
    /**
     * 服务对象
     */
    @Resource
    private ComJobStuService comJobStuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @RequestMapping("selectOne/{id}")
//    public String selectOne(@PathVariable Integer id) {
//        Gson gson=new Gson();
//        return gson.toJson(this.comJobStuService.queryById(id));
//
//    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("all")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.comJobStuService.all());
         
    }

    /**
     * 通过招聘ID查询所有应聘的学生
     * @param jid 招聘ID
     * @return 所有学生
     */
    @RequestMapping(value = "getByJid",method = RequestMethod.GET)
    public String queryJob(Integer jid){
        List<ComJobStu> comJobStus=this.comJobStuService.queryByPId(jid);
        if(comJobStus.size()!=0){
            return ResponseMsg.success(comJobStus);
        }else{
            return ResponseMsg.fail();
        }
    }

}