package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.CompanyInfo;
import com.cn.entity.StudentInfo;
import com.cn.entity.User;
import com.cn.service.CompanyInfoService;
import com.cn.service.StudentInfoService;
import com.cn.service.UserService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * (User)表控制层
 *
 * @author kai
 * @since 2018-11-17 18:05:05
 */
@CrossOrigin
@RestController
@RequestMapping(value = "user",produces = "text/html;charset=utf-8")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private CompanyInfoService companyInfoService;

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
        return gson.toJson(this.userService.queryById(id));
    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("/")
    public String all(@RequestParam int page,@RequestParam int limit) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg",1);
        jsonObject.put("item",this.userService.queryAllByLimit(page,limit));
        jsonObject.put("count",this.userService.queryAllByLimit(page,limit).size());
        return jsonObject.toString();
    }

    /**
     * 注册操作
     * @param request 表单提交数据
     * @return 注册信息
     * 注册成功 1
     * 注册失败 0
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String insertUser(HttpServletRequest request ){
        User user=new User();
        user.setUName(request.getParameter("uName"));
//        对密码进行编码
        BASE64Encoder base64Encoder=new BASE64Encoder();
        String afterPw=base64Encoder.encode(
                (request.getParameter("uPassword")).getBytes());
        user.setUPassword(afterPw);
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

    /**
     * 登录
     * @param phone 手机号
     * @param pw 密码
     * @return 登录信息
     * 企业 1
     * 学生 2
     * 密码错误 -1
     * 用户不存在 0
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String phone, String pw){
//        用户查询信息
        int i=this.userService.login(phone,pw);
        JSONObject jsonObject=new JSONObject();
        if(i==0){
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }else if(i==-1){
            jsonObject.put("msg",-1);
            return jsonObject.toString();
        }else if(i==1){
            jsonObject.put("msg",1);
            //手机号获取企业号
            CompanyInfo companyInfo=this.companyInfoService.queryCompany(phone);
            if(companyInfo==null){
                jsonObject.put("cid",null);
            }
            jsonObject.put("cid",companyInfo.getCId());
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",2);
            // 通过手机号获取学号
            StudentInfo studentInfo=this.studentInfoService.queryStudent(phone);
            if(studentInfo==null){
                jsonObject.put("sid",null);
            }
            jsonObject.put("sid",studentInfo.getSId());
            return jsonObject.toString();
        }
    }

    /**
     * 检查手机号
     * @param phone 手机号
     * @return 信息
     * 手机号已被注册 1
     * 没被注册 0
     */
    @RequestMapping(value = "checkPhone",method = RequestMethod.GET)
    public String phone(String phone){
        boolean Phone=this.userService.checkPhone(phone);
        JSONObject jsonObject=new JSONObject();
        if(Phone){
            jsonObject.put("msg",1);
            return jsonObject.toString();
        }else {
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }

    }

    /**
     * 检查用户名
     * @param username 用户名
     * @return
     * 用户名已被注册 1
     * 没被注册 0
     */
    @RequestMapping(value = "checkName",method = RequestMethod.GET)
    public String username(String username){
        boolean Username=this.userService.checkUsername(username);
        JSONObject jsonObject=new JSONObject();
        if(Username){
            jsonObject.put("msg",1);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }

    /**
     * 获取用户信息
     * @param phone 手机号
     * @return json信息
     */
    @RequestMapping(value = "info",method = RequestMethod.GET)
    public String queryUser(String phone){
        User user=this.userService.queryByPhone(phone);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("info",user);
        return jsonObject.toString();
    }

}