package com.cn.service;

import com.cn.entity.StudentInfo;
import java.util.List;

/**
 * (StudentInfo)表服务接口
 *
 * @author kai
 * @since 2018-11-23 00:14:44
 */
public interface StudentInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StudentInfo queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<StudentInfo> all(boolean flag);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StudentInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param studentInfo 实例对象
     * @return 影响行数
     */
    StudentInfo insert(StudentInfo studentInfo);

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
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     *
     * @param phone 手机号
     * @return 对象
     */
    StudentInfo queryStudent(String phone);


    /**
     * 查询所有学生的信息
     * @param sid 学号
     * @return 学生信息
     */
    StudentInfo queryAllInfo(String sid);

    /**
     * 通过学号审核信息
     * @param sid 学号
     * @return 更改信息
     */
    int updateStudent(String sid);

}