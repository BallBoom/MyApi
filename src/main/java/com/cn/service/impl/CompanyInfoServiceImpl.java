package com.cn.service.impl;

import com.cn.entity.CompanyInfo;
import com.cn.dao.CompanyInfoDao;
import com.cn.service.CompanyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CompanyInfo)表服务实现类
 *
 * @author kai
 * @since 2018-11-24 23:46:19
 */
@Service("companyInfoService")
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Resource
    private CompanyInfoDao companyInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CompanyInfo queryById(Integer id) {
        return this.companyInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CompanyInfo> queryAllByLimit(int offset, int limit) {
        return this.companyInfoDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<CompanyInfo> all(){
        return this.companyInfoDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param companyInfo 实例对象
     * @return 实例对象
     */
    @Override
    public CompanyInfo insert(CompanyInfo companyInfo) {
        this.companyInfoDao.insert(companyInfo);
        return companyInfo;
    }

    /**
     * 修改数据
     *
     * @param companyInfo 实例对象
     * @return 实例对象
     */
    @Override
    public CompanyInfo update(CompanyInfo companyInfo) {
        this.companyInfoDao.update(companyInfo);
        return this.queryById(companyInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.companyInfoDao.deleteById(id) > 0;
    }

    /**
     * 通过手机号查询企业信息
     *
     * @param phone 手机号
     * @return 对象
     */
    @Override
    public CompanyInfo queryCompany(String phone) {
        return this.companyInfoDao.queryCompany(phone);
    }
}