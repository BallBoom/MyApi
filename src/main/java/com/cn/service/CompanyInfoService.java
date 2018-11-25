package com.cn.service;

import com.cn.entity.CompanyInfo;
import java.util.List;

/**
 * (CompanyInfo)表服务接口
 *
 * @author kai
 * @since 2018-11-24 23:46:19
 */
public interface CompanyInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CompanyInfo queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<CompanyInfo> all();
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CompanyInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param companyInfo 实例对象
     * @return 实例对象
     */
    CompanyInfo insert(CompanyInfo companyInfo);

    /**
     * 修改数据
     *
     * @param companyInfo 实例对象
     * @return 实例对象
     */
    CompanyInfo update(CompanyInfo companyInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过手机号查询企业信息
     * @param phone 手机号
     * @return 对象
     */
    CompanyInfo queryCompany(String phone);
}