package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.User;
import com.cn.service.UserService;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (User)表控制层
 *
 * @author kai
 * @since 2018-11-17 18:05:05
 */
@RestController
@RequestMapping(value = "user",produces = "text/html;charset=utf-8")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        String result=gson.toJson(this.userService.queryById(id));
        return result;
    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("all")
    public String all() {
        Gson gson=new Gson();
        String result=gson.toJson(this.userService.all());
        return result;
    }

    /**
     * 注册操作
     * @param request 表单提交数据
     * @return 注册信息
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String insertUser(HttpServletRequest request){
        User user=new User();
        user.setUName(request.getParameter("uName"));
        user.setUPassword(request.getParameter("uPassword"));
        user.setRoleId(Integer.parseInt(request.getParameter("roleId")));
        user.setUPhone(request.getParameter("uPhone"));
        user.setUQq(request.getParameter("uQq"));
        user.setUEmail(request.getParameter("uEmail"));
        Date date=new Date();
        java.sql.Date nowData=new java.sql.Date(date.getTime());
        user.setURegister(nowData);
        int i=this.userService.insert(user);
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