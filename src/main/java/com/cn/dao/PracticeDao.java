package com.cn.dao;

import com.cn.entity.Practice;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Practice)表数据库访问层
 *
 * @author kai
 * @since 2018-11-25 22:10:43
 */
public interface PracticeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Practice queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Practice> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param practice 实例对象
     * @return 对象列表
     */
    List<Practice> queryAll(Practice practice);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<Practice> all();
    
    /**
     * 新增数据
     *
     * @param practice 实例对象
     * @return 影响行数
     */
    int insert(Practice practice);

    /**
     * 修改数据
     *
     * @param practice 实例对象
     * @return 影响行数
     */
    int update(Practice practice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询社会实践
     * @param sid 学号
     * @return 社会实践信息
     */
    List<Practice> queryBysId(String sid);

}