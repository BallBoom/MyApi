package com.cn.service.impl;

import com.cn.entity.StuAchCom;
import com.cn.dao.StuAchComDao;
import com.cn.service.StuAchComService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (StuAchCom)表服务实现类
 *
 * @author kai
 * @since 2018-12-02 15:29:47
 */
@Service("stuAchComService")
public class StuAchComServiceImpl implements StuAchComService {
    @Resource
    private StuAchComDao stuAchComDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StuAchCom queryById(Integer id) {
        return this.stuAchComDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<StuAchCom> queryAllByLimit(int offset, int limit) {
        return this.stuAchComDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<StuAchCom> all(){
        return this.stuAchComDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param stuAchCom 实例对象
     * @return 实例对象
     */
    @Override
    public StuAchCom insert(StuAchCom stuAchCom) {
        this.stuAchComDao.insert(stuAchCom);
        return stuAchCom;
    }

    /**
     * 修改数据
     *
     * @param stuAchCom 实例对象
     * @return 实例对象
     */
    @Override
    public StuAchCom update(StuAchCom stuAchCom) {
        this.stuAchComDao.update(stuAchCom);
        return this.queryById(stuAchCom.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.stuAchComDao.deleteById(id) > 0;
    }
}