package com.cn.dao;

import com.cn.entity.ComProStu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ComProStu)表数据库访问层
 *
 * @author kai
 * @since 2018-11-28 15:54:35
 */
public interface ComProStuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ComProStu queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ComProStu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param comProStu 实例对象
     * @return 对象列表
     */
    List<ComProStu> queryAll(ComProStu comProStu);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<ComProStu> all();
    
    /**
     * 新增数据
     *
     * @param comProStu 实例对象
     * @return 影响行数
     */
    int insert(ComProStu comProStu);

    /**
     * 修改数据
     *
     * @param comProStu 实例对象
     * @return 影响行数
     */
    int update(ComProStu comProStu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询竞标学生
     * @param pid 项目ID
     * @return 竞标学生信息
     */
    List<ComProStu> queryStudentBypId(String pid);

    /**
     * 学号查询项目ID
     * @param sid 学号
     * @return 所有相关ID
     */
    List<Integer> queryPidBySid(String sid);


}