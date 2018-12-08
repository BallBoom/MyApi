package com.cn.service;

import com.cn.entity.ProCompany;

import java.sql.Timestamp;
import java.util.List;

/**
 * (ProCompany)表服务接口
 *
 * @author kai
 * @since 2018-11-25 22:26:26
 */
public interface ProCompanyService {

    /**
     * 通过项目ID查询数据
     *
     * @param id 项目ID
     * @return 实例对象
     */
    ProCompany queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<ProCompany> all(boolean flag);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProCompany> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param proCompany 实例对象
     * @return 实例对象
     */
    ProCompany insert(ProCompany proCompany);

    /**
     * 修改数据
     *
     * @param proCompany 实例对象
     * @return 实例对象
     */
    int update(ProCompany proCompany);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 企业号查询发布的项目
     * @param cid 企业号
     * @return 对象数据
     */
    List<ProCompany> queryProAndCommentByCId(String cid);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param proCompany 实例对象
     * @return 对象列表
     */
    List<ProCompany> queryAll(ProCompany proCompany);

    /**
     * 审核项目，添加审核时间
     * @param pubDate 审核时间
     *                ID 项目号
     * @return 返回影响行数
     */
    int updateProFlag(Timestamp pubDate,Integer id);

}