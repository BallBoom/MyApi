package com.cn.controller;

import com.cn.entity.StuAchCom;
import com.cn.service.StuAchComService;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import javax.annotation.Resource;

/**
 * (StuAchCom)表控制层
 *
 * @author kai
 * @since 2018-12-02 15:29:47
 */
@CrossOrigin
@RestController
@RequestMapping(value="stuAchCom",produces = "text/html;charset=utf-8")
public class StuAchComController {
    /**
     * 服务对象
     */
    @Resource
    private StuAchComService stuAchComService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.stuAchComService.queryById(id));

    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("all")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.stuAchComService.all());
         
    }

}