package com.cn.service;

import com.cn.entity.StuLetter;
import java.util.List;

/**
 * (StuLetter)表服务接口
 *
 * @author kai
 * @since 2018-12-02 15:40:08
 */
public interface StuLetterService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StuLetter queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<StuLetter> all();
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StuLetter> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param stuLetter 实例对象
     * @return 实例对象
     */
    StuLetter insert(StuLetter stuLetter);

    /**
     * 修改数据
     *
     * @param stuLetter 实例对象
     * @return 实例对象
     */
    StuLetter update(StuLetter stuLetter);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 学生查询推荐信
     * @param sid 学号
     * @return 推荐信
     */
    StuLetter queryLetter(String sid);


}