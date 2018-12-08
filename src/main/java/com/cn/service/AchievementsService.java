package com.cn.service;

import com.cn.entity.Achievements;
import java.util.List;

/**
 * (Achievements)表服务接口
 *
 * @author kai
 * @since 2018-11-25 18:05:33
 */
public interface AchievementsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Achievements queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<Achievements> all();
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Achievements> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param achievements 实例对象
     * @return 实例对象
     */
    Achievements insert(Achievements achievements);

    /**
     * 修改数据
     *
     * @param achievements 实例对象
     * @return 实例对象
     */
    Achievements update(Achievements achievements);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据学号查询自己全部成果
     * @param fksid 学号
     * @return 对象
     */
    List<Achievements> queryByfkSId(String fksid);

}