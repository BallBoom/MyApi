package com.cn.service;

import com.cn.entity.ComJobStu;
import java.util.List;

/**
 * (ComJobStu)表服务接口
 *
 * @author kai
 * @since 2018-11-29 11:55:23
 */
public interface ComJobStuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<ComJobStu> queryByPId(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<ComJobStu> all();
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ComJobStu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param comJobStu 实例对象
     * @return 实例对象
     */
    ComJobStu insert(ComJobStu comJobStu);

    /**
     * 修改数据
     *
     * @param comJobStu 实例对象
     * @return 实例对象
     */
//    ComJobStu update(ComJobStu comJobStu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}