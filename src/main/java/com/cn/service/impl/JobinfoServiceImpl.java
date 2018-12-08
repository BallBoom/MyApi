package com.cn.service.impl;

import com.cn.entity.Jobinfo;
import com.cn.dao.JobinfoDao;
import com.cn.service.JobinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * (Jobinfo)表服务实现类
 *
 * @author kai
 * @since 2018-11-25 22:21:11
 */
@Service("jobinfoService")
public class JobinfoServiceImpl implements JobinfoService {
    @Resource
    private JobinfoDao jobinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Jobinfo queryById(Integer id) {
        return this.jobinfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Jobinfo> queryAllByLimit(int offset, int limit) {
        return this.jobinfoDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<Jobinfo> all(boolean flag){
        return this.jobinfoDao.all(flag);
    }
    

    /**
     * 新增数据
     *
     * @param jobinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Jobinfo insert(Jobinfo jobinfo) {
        this.jobinfoDao.insert(jobinfo);
        return jobinfo;
    }

    /**
     * 修改数据
     *
     * @param jobinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Jobinfo update(Jobinfo jobinfo) {
        this.jobinfoDao.update(jobinfo);
        return this.queryById(jobinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.jobinfoDao.deleteById(id) > 0;
    }

    /**
     * 企业查询招聘
     *
     * @param fkcid 企业号
     * @return
     */
    @Override
    public List<Jobinfo> queryByCId(String fkcid) {
        return this.jobinfoDao.queryByCId(fkcid);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param jobinfo 实例对象
     * @return 对象列表
     */
    @Override
    public List<Jobinfo> queryAllByJob(Jobinfo jobinfo) {
        return this.jobinfoDao.queryAllByJob(jobinfo);
    }

    /**
     * 管理员审核招聘信息
     *
     * @param pubDate 当前时间
     * @param id      招聘ID
     * @return 影响行数
     */
    @Override
    public int updateJobFlag(Timestamp pubDate, Integer id) {
        return this.jobinfoDao.updateJobFlag(pubDate,id);
    }


}