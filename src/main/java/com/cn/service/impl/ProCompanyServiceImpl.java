package com.cn.service.impl;

import com.cn.dao.ProCompanyDao;
import com.cn.entity.ProCompany;
import com.cn.service.ProCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * (ProCompany)表服务实现类
 *
 * @author kai
 * @since 2018-11-25 22:26:26
 */
@Service("proCompanyService")
public class ProCompanyServiceImpl implements ProCompanyService {
    @Resource
    private ProCompanyDao proCompanyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProCompany queryById(Integer id) {
        return this.proCompanyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProCompany> queryAllByLimit(int offset, int limit) {
        return this.proCompanyDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<ProCompany> all(boolean flag){
        return this.proCompanyDao.all(flag);
    }
    

    /**
     * 新增数据
     *
     * @param proCompany 实例对象
     * @return 实例对象
     */
    @Override
    public ProCompany insert(ProCompany proCompany) {
        this.proCompanyDao.insert(proCompany);
        return proCompany;
    }

    /**
     * 修改数据
     *
     * @param proCompany 实例对象
     * @return 实例对象
     */
    @Override
    public int update(ProCompany proCompany) {
        return this.proCompanyDao.update(proCompany);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.proCompanyDao.deleteById(id) > 0;
    }

    /**
     * 企业号查询发布的项目
     *
     * @param cid 企业号
     * @return 对象数据
     */
    @Override
    public List<ProCompany> queryProAndCommentByCId(String cid) {
        return this.proCompanyDao.queryProAndCommentByCId(cid);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param proCompany 实例对象
     * @return 对象列表
     */
    @Override
    public List<ProCompany> queryAll(ProCompany proCompany) {
        return this.proCompanyDao.queryAll(proCompany);
    }

    /**
     * 审核项目，添加审核时间
     *
     * @param pubDate 审核时间
     * @param id
     * @return 返回影响行数
     */
    @Override
    public int updateProFlag(Timestamp pubDate, Integer id) {
        return this.proCompanyDao.updateProFlag(pubDate,id);
    }


}