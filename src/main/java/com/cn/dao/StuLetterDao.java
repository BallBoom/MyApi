package com.cn.dao;

import com.cn.entity.StuLetter;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (StuLetter)表数据库访问层
 *
 * @author kai
 * @since 2018-12-02 15:40:08
 */
public interface StuLetterDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StuLetter queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StuLetter> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param stuLetter 实例对象
     * @return 对象列表
     */
    List<StuLetter> queryAll(StuLetter stuLetter);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<StuLetter> all();
    
    /**
     * 新增数据
     *
     * @param stuLetter 实例对象
     * @return 影响行数
     */
    int insert(StuLetter stuLetter);

    /**
     * 修改数据
     *
     * @param stuLetter 实例对象
     * @return 影响行数
     */
    int update(StuLetter stuLetter);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 学生查询推荐信
     * @param sid 学号
     * @return 推荐信
     */
    StuLetter queryLetter(String sid);

}