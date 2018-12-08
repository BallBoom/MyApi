package com.cn.dao;

import com.cn.entity.ComJobStu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ComJobStu)表数据库访问层
 *
 * @author kai
 * @since 2018-11-29 11:55:23
 */
public interface ComJobStuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<ComJobStu> queryByPId(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ComJobStu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param comJobStu 实例对象
     * @return 对象列表
     */
    List<ComJobStu> queryAll(ComJobStu comJobStu);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<ComJobStu> all();
    
    /**
     * 新增数据
     *
     * @param comJobStu 实例对象
     * @return 影响行数
     */
    int insert(ComJobStu comJobStu);

    /**
     * 修改数据
     *
     * @param comJobStu 实例对象
     * @return 影响行数
     */
    int update(ComJobStu comJobStu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}