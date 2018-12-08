package com.cn.service;

import com.cn.entity.Jobinfo;

import java.sql.Timestamp;
import java.util.List;

/**
 * (Jobinfo)表服务接口
 *
 * @author kai
 * @since 2018-11-25 22:21:11
 */
public interface JobinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Jobinfo queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<Jobinfo> all(boolean flag);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Jobinfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param jobinfo 实例对象
     * @return 实例对象
     */
    Jobinfo insert(Jobinfo jobinfo);

    /**
     * 修改数据
     *
     * @param jobinfo 实例对象
     * @return 实例对象
     */
    Jobinfo update(Jobinfo jobinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 企业查询招聘
     * @param fkcid 企业号
     * @return
     */
    List<Jobinfo> queryByCId(String fkcid);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param jobinfo 实例对象
     * @return 对象列表
     */
    List<Jobinfo> queryAllByJob(Jobinfo jobinfo);

    /**
     * 管理员审核招聘信息
     * @param pubDate 当前时间
     * @param id 招聘ID
     * @return 影响行数
     */
    int updateJobFlag(Timestamp pubDate, Integer id);
}