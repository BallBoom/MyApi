package com.cn.dao;

import com.cn.entity.ProfWorks;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ProfWorks)表数据库访问层
 *
 * @author kai
 * @since 2018-12-03 17:01:01
 */
public interface ProfWorksDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProfWorks queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProfWorks> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param profWorks 实例对象
     * @return 对象列表
     */
    List<ProfWorks> queryAll(ProfWorks profWorks);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<ProfWorks> all();
    
    /**
     * 新增数据
     *
     * @param profWorks 实例对象
     * @return 影响行数
     */
    int insert(ProfWorks profWorks);

    /**
     * 修改数据
     *
     * @param profWorks 实例对象
     * @return 影响行数
     */
    int update(ProfWorks profWorks);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 按学号查询
     * @param sid 学号
     * @return 作品信息
     */
    List<ProfWorks> queryBySId(String sid);

}