package com.cn.dao;

import com.cn.entity.ProCompany;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * (ProCompany)表数据库访问层
 *
 * @author kai
 * @since 2018-11-25 22:26:26
 */
public interface ProCompanyDao {

    /**
     * 通过项目ID查询数据
     *
     * @param id 项目
     * @return 所有对象
     */
    ProCompany queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProCompany> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param proCompany 实例对象
     * @return 对象列表
     */
    List<ProCompany> queryAll(ProCompany proCompany);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<ProCompany> all(boolean flag);
    
    /**
     * 新增数据
     *
     * @param proCompany 实例对象
     * @return 影响行数
     */
    int insert(ProCompany proCompany);

    /**
     * 修改数据
     *
     * @param proCompany 实例对象
     * @return 影响行数
     */
    int update(ProCompany proCompany);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 企业号查询发布的项目
     * @param cid 企业号
     * @return 对象数据
     */
    List<ProCompany> queryProAndCommentByCId(String cid);

    /**
     * 审核项目，添加审核时间
     * @param pubDate 当前时间
     * @param id 项目号
     * @return 返回影响行数
     */
    int updateProFlag(@Param("pubDate") Timestamp pubDate,@Param("id") Integer id);


}