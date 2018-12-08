package com.cn.service.impl;

import com.cn.entity.Achievements;
import com.cn.dao.AchievementsDao;
import com.cn.service.AchievementsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Achievements)表服务实现类
 *
 * @author kai
 * @since 2018-11-25 18:05:33
 */
@Service("achievementsService")
public class AchievementsServiceImpl implements AchievementsService {
    @Resource
    private AchievementsDao achievementsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Achievements queryById(Integer id) {
        return this.achievementsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Achievements> queryAllByLimit(int offset, int limit) {
        return this.achievementsDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<Achievements> all(){
        return this.achievementsDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param achievements 实例对象
     * @return 实例对象
     */
    @Override
    public Achievements insert(Achievements achievements) {
        this.achievementsDao.insert(achievements);
        return achievements;
    }

    /**
     * 修改数据
     *
     * @param achievements 实例对象
     * @return 实例对象
     */
    @Override
    public Achievements update(Achievements achievements) {
        this.achievementsDao.update(achievements);
        return this.queryById(achievements.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.achievementsDao.deleteById(id) > 0;
    }

    /**
     * 根据学号查询自己全部成果
     *
     * @param fksid 学号
     * @return 对象
     */
    @Override
    public List<Achievements> queryByfkSId(String fksid) {
        return this.achievementsDao.queryByfkSId(fksid);
    }
}