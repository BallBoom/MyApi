package com.cn.dao;

import com.cn.entity.StuAchCom;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (StuAchCom)表数据库访问层
 *
 * @author kai
 * @since 2018-12-02 15:29:47
 */
public interface StuAchComDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StuAchCom queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StuAchCom> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param stuAchCom 实例对象
     * @return 对象列表
     */
    List<StuAchCom> queryAll(StuAchCom stuAchCom);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<StuAchCom> all();
    
    /**
     * 新增数据
     *
     * @param stuAchCom 实例对象
     * @return 影响行数
     */
    int insert(StuAchCom stuAchCom);

    /**
     * 修改数据
     *
     * @param stuAchCom 实例对象
     * @return 影响行数
     */
    int update(StuAchCom stuAchCom);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}