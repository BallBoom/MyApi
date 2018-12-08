package com.cn.service;

import com.cn.entity.ProfWorks;
import java.util.List;

/**
 * (ProfWorks)表服务接口
 *
 * @author kai
 * @since 2018-12-03 17:01:01
 */
public interface ProfWorksService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProfWorks queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<ProfWorks> all();
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProfWorks> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param profWorks 实例对象
     * @return 实例对象
     */
    ProfWorks insert(ProfWorks profWorks);

    /**
     * 修改数据
     *
     * @param profWorks 实例对象
     * @return 实例对象
     */
    ProfWorks update(ProfWorks profWorks);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 按学号查询
     * @param sid 学号
     * @return 作品信息
     */
    List<ProfWorks> queryBySId(String sid);

}