package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.entity.Achievements;
import com.cn.service.AchievementsService;
import com.cn.utils.UploadUtil;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * (Achievements)表控制层
 *
 * @author kai
 * @since 2018-11-25 18:05:33
 */
@CrossOrigin
@RestController
@RequestMapping(value="achievements",produces = "text/html;charset=utf-8")
public class AchievementsController {
    /**
     * 服务对象
     */
    @Resource
    private AchievementsService achievementsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.achievementsService.queryById(id));
    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("/")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.achievementsService.all());

    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String insertAchievements(HttpServletRequest request, @RequestParam(value = "aProve") MultipartFile file) throws IOException {
        Achievements achievements=new Achievements();
        achievements.setFkSId(request.getParameter("fkSId"));
        achievements.setAName(request.getParameter("aName"));
        String formData=request.getParameter("aTime");
        java.sql.Date aData=java.sql.Date.valueOf(formData);
        achievements.setATime(aData);
        achievements.setAPersons(Integer.parseInt(request.getParameter("aPersons")));
        achievements.setWorksName(request.getParameter("worksName"));
        achievements.setAComplete(request.getParameter("aComplete"));
        achievements.setIsReward(request.getParameter("isReward"));
        achievements.setIsPatent(request.getParameter("isPatent"));
        // 保存图片
        String imgName= UploadUtil.imgUpload(file);
        achievements.setAProve(imgName);
        Achievements achievements1=this.achievementsService.insert(achievements);
        JSONObject jsonObject=new JSONObject();
        if(achievements1!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",achievements);
            return jsonObject.toString();
        }else{
            jsonObject.put("msg",0);
            return jsonObject.toString();
        }
    }

    /**
     * 根据学号查询自己全部成果
     * @param fkSId 学号
     * @return json对象
     */
    @RequestMapping(value = "getBysid",method = RequestMethod.GET)
    public String selctByfsid(@RequestParam String fkSId){
        List<Achievements> list=this.achievementsService.queryByfkSId(fkSId);
        JSONObject jsonObject=new JSONObject();
        if(list!=null){
            jsonObject.put("msg",1);
            jsonObject.put("data",list);
            return jsonObject.toString();
        }
        jsonObject.put("msg",0);
        return jsonObject.toString();
    }

}