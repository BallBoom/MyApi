package com.cn.dao;

import com.cn.entity.StudentInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (StudentInfo)表数据库访问层
 *
 * @author kai
 * @since 2018-11-23 00:14:44
 */
public interface StudentInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StudentInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StudentInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param studentInfo 实例对象
     * @return 对象列表
     */
    List<StudentInfo> queryAll(StudentInfo studentInfo);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<StudentInfo> all();
    
    /**
     * 新增数据
     *
     * @param studentInfo 实例对象
     * @return 影响行数
     */
    int insert(StudentInfo studentInfo);

    /**
     * 修改数据
     *
     * @param studentInfo 实例对象
     * @return 影响行数
     */
    int update(StudentInfo studentInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     *
     * @param phone 手机号
     * @return 学生信息
     */
    StudentInfo queryStudent(String phone);

    /**
     * 查询所有学生的信息
     * @param sid 学号
     * @return 学生信息
     */
    StudentInfo queryAllInfo(String sid);

}