package com.cn.controller;

import com.cn.entity.ProfWorks;
import com.cn.service.ProfWorksService;
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
 * (ProfWorks)表控制层
 *
 * @author kai
 * @since 2018-12-03 17:01:01
 */
@CrossOrigin
@RestController
@RequestMapping(value="profWorks",produces = "text/html;charset=utf-8")
public class ProfWorksController {
    /**
     * 服务对象
     */
    @Resource
    private ProfWorksService profWorksService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne/{id}")
    public String selectOne(@PathVariable Integer id) {
        Gson gson=new Gson();
        return gson.toJson(this.profWorksService.queryById(id));

    }
    
    
    /**
     * 无条件查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("all")
    public String all() {
        Gson gson=new Gson();
        return gson.toJson(this.profWorksService.all());
         
    }

    /**
     * 学生添加专业作品
     * @param request 前台数据
     * @param file 图片
     * @return 添加信息
     * @throws IOException 输入流异常
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String insertProf(HttpServletRequest request, @RequestParam(value = "wPhoto")MultipartFile file) throws IOException {
        ProfWorks profWorks=new ProfWorks();
        profWorks.setFkSId(request.getParameter("fkSId"));
        profWorks.setWName(request.getParameter("wName"));
        java.sql.Date wDate=java.sql.Date.valueOf(request.getParameter("wDate"));
        profWorks.setWDate(wDate);
        profWorks.setWIntroduction(request.getParameter("wIntroduction"));
        //保存图片
        String imgName= UploadUtil.imgUpload(file);
        profWorks.setWPhoto(imgName);

        ProfWorks profWorks1=this.profWorksService.insert(profWorks);
        if(profWorks1!=null){
            return ResponseMsg.success(profWorks1);
        }else{
            return ResponseMsg.fail();
        }
    }

    /**
     * 按学号查询作品
     * @param fkSId 学号
     * @return 查询结果
     */
    @RequestMapping(value = "getBySId",method = RequestMethod.GET)
    public String queryPorf(String fkSId){
        List<ProfWorks> profWorksList=this.profWorksService.queryBySId(fkSId);
        if(profWorksList.size()!=0){
            return ResponseMsg.success(profWorksList);
        }else{
            return ResponseMsg.fail();
        }
    }

}