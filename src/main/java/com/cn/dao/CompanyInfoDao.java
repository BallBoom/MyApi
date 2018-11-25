package com.cn.dao;

import com.cn.entity.CompanyInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CompanyInfo)表数据库访问层
 *
 * @author kai
 * @since 2018-11-24 23:46:19
 */
public interface CompanyInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CompanyInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CompanyInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param companyInfo 实例对象
     * @return 对象列表
     */
    List<CompanyInfo> queryAll(CompanyInfo companyInfo);

    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<CompanyInfo> all();
    
    /**
     * 新增数据
     *
     * @param companyInfo 实例对象
     * @return 影响行数
     */
    int insert(CompanyInfo companyInfo);

    /**
     * 修改数据
     *
     * @param companyInfo 实例对象
     * @return 影响行数
     */
    int update(CompanyInfo companyInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过手机号查询企业信息
     * @param phone 手机号
     * @return 对象
     */
    CompanyInfo queryCompany(String phone);

}