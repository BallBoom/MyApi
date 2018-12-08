package com.cn.service;

import com.cn.entity.StuAchCom;
import java.util.List;

/**
 * (StuAchCom)表服务接口
 *
 * @author kai
 * @since 2018-12-02 15:29:47
 */
public interface StuAchComService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StuAchCom queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<StuAchCom> all();
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StuAchCom> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param stuAchCom 实例对象
     * @return 实例对象
     */
    StuAchCom insert(StuAchCom stuAchCom);

    /**
     * 修改数据
     *
     * @param stuAchCom 实例对象
     * @return 实例对象
     */
    StuAchCom update(StuAchCom stuAchCom);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}