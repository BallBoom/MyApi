package com.cn.service.impl;

import com.cn.entity.ProfWorks;
import com.cn.dao.ProfWorksDao;
import com.cn.service.ProfWorksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProfWorks)表服务实现类
 *
 * @author kai
 * @since 2018-12-03 17:01:01
 */
@Service("profWorksService")
public class ProfWorksServiceImpl implements ProfWorksService {
    @Resource
    private ProfWorksDao profWorksDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProfWorks queryById(Integer id) {
        return this.profWorksDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProfWorks> queryAllByLimit(int offset, int limit) {
        return this.profWorksDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<ProfWorks> all(){
        return this.profWorksDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param profWorks 实例对象
     * @return 实例对象
     */
    @Override
    public ProfWorks insert(ProfWorks profWorks) {
        this.profWorksDao.insert(profWorks);
        return profWorks;
    }

    /**
     * 修改数据
     *
     * @param profWorks 实例对象
     * @return 实例对象
     */
    @Override
    public ProfWorks update(ProfWorks profWorks) {
        this.profWorksDao.update(profWorks);
        return this.queryById(profWorks.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.profWorksDao.deleteById(id) > 0;
    }

    /**
     * 按学号查询
     *
     * @param sid 学号
     * @return 作品信息
     */
    @Override
    public List<ProfWorks> queryBySId(String sid) {
        return this.profWorksDao.queryBySId(sid);
    }
}