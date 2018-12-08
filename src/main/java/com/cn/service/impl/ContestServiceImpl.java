package com.cn.service.impl;

import com.cn.entity.Contest;
import com.cn.dao.ContestDao;
import com.cn.service.ContestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Contest)表服务实现类
 *
 * @author kai
 * @since 2018-11-25 22:09:33
 */
@Service("contestService")
public class ContestServiceImpl implements ContestService {
    @Resource
    private ContestDao contestDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Contest queryById(Integer id) {
        return this.contestDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Contest> queryAllByLimit(int offset, int limit) {
        return this.contestDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<Contest> all(){
        return this.contestDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param contest 实例对象
     * @return 实例对象
     */
    @Override
    public Contest insert(Contest contest) {
        this.contestDao.insert(contest);
        return contest;
    }

    /**
     * 修改数据
     *
     * @param contest 实例对象
     * @return 实例对象
     */
    @Override
    public Contest update(Contest contest) {
        this.contestDao.update(contest);
        return this.queryById(contest.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.contestDao.deleteById(id) > 0;
    }


    /**
     * 学号查询竞赛
     *
     * @param fksid
     * @return
     */
    @Override
    public List<Contest> queryBySid(String fksid) {
        return this.contestDao.queryBySid(fksid);
    }
}