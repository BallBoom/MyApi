package com.cn.service;

import com.cn.entity.Practice;
import java.util.List;

/**
 * (Practice)表服务接口
 *
 * @author kai
 * @since 2018-11-25 22:10:43
 */
public interface PracticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Practice queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<Practice> all();
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Practice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param practice 实例对象
     * @return 实例对象
     */
    Practice insert(Practice practice);

    /**
     * 修改数据
     *
     * @param practice 实例对象
     * @return 实例对象
     */
    Practice update(Practice practice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询社会实践
     * @param sid 学号
     * @return 社会实践信息
     */
    List<Practice> queryBysId(String sid);

}