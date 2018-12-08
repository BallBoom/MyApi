package com.cn.dao;

import com.cn.entity.Jobinfo;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * (Jobinfo)表数据库访问层
 *
 * @author kai
 * @since 2018-11-25 22:21:11
 */
public interface JobinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Jobinfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Jobinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过招聘信息作为筛选条件模糊查询
     *
     * @param jobinfo 实例对象
     * @return 对象列表
     */
    List<Jobinfo> queryAllByJob(Jobinfo jobinfo);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<Jobinfo> all(boolean flag);
    
    /**
     * 新增数据
     *
     * @param jobinfo 实例对象
     * @return 影响行数
     */
    int insert(Jobinfo jobinfo);

    /**
     * 修改数据
     *
     * @param jobinfo 实例对象
     * @return 影响行数
     */
    int update(Jobinfo jobinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 企业查询招聘信息
     * @param fkcid
     * @return
     */
    List<Jobinfo> queryByCId(String fkcid);

    /**
     * 管理员审核招聘信息
     * @param pubDate 当前时间
     * @param id 招聘ID
     * @return 影响行数
     */
    int updateJobFlag(@Param("pubDate") Timestamp pubDate,@Param("id") Integer id);
}