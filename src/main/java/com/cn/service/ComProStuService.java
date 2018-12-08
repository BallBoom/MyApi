package com.cn.service;

import com.cn.entity.ComProStu;
import java.util.List;

/**
 * (ComProStu)表服务接口
 *
 * @author kai
 * @since 2018-11-28 15:54:35
 */
public interface ComProStuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ComProStu queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<ComProStu> all();
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ComProStu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param comProStu 实例对象
     * @return 实例对象
     */
    ComProStu insert(ComProStu comProStu);

    /**
     * 修改数据
     *
     * @param comProStu 实例对象
     * @return 实例对象
     */
    ComProStu update(ComProStu comProStu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 企业查询竞标学生
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