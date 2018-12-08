package com.cn.dao;

import com.cn.entity.Contest;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Contest)表数据库访问层
 *
 * @author kai
 * @since 2018-11-25 22:09:33
 */
public interface ContestDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Contest queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Contest> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param contest 实例对象
     * @return 对象列表
     */
    List<Contest> queryAll(Contest contest);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<Contest> all();
    
    /**
     * 新增数据
     *
     * @param contest 实例对象
     * @return 影响行数
     */
    int insert(Contest contest);

    /**
     * 修改数据
     *
     * @param contest 实例对象
     * @return 影响行数
     */
    int update(Contest contest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 学号查询竞赛
     * @param fksid
     * @return
     */
    List<Contest> queryBySid(String fksid);
}