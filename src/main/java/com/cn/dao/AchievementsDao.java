package com.cn.dao;

import com.cn.entity.Achievements;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Achievements)表数据库访问层
 *
 * @author kai
 * @since 2018-11-25 18:05:33
 */
public interface AchievementsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Achievements queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Achievements> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param achievements 实例对象
     * @return 对象列表
     */
    List<Achievements> queryAll(Achievements achievements);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<Achievements> all();
    
    /**
     * 新增数据
     *
     * @param achievements 实例对象
     * @return 影响行数
     */
    int insert(Achievements achievements);

    /**
     * 修改数据
     *
     * @param achievements 实例对象
     * @return 影响行数
     */
    int update(Achievements achievements);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据学号查询自己全部成果
     * @param fksid 学号
     * @return 对象
     */
    List<Achievements> queryByfkSId(String fksid);

}