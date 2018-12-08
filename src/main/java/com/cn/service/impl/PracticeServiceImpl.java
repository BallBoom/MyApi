package com.cn.service.impl;

import com.cn.entity.Practice;
import com.cn.dao.PracticeDao;
import com.cn.service.PracticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Practice)表服务实现类
 *
 * @author kai
 * @since 2018-11-25 22:10:43
 */
@Service("practiceService")
public class PracticeServiceImpl implements PracticeService {
    @Resource
    private PracticeDao practiceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Practice queryById(Integer id) {
        return this.practiceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Practice> queryAllByLimit(int offset, int limit) {
        return this.practiceDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<Practice> all(){
        return this.practiceDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param practice 实例对象
     * @return 实例对象
     */
    @Override
    public Practice insert(Practice practice) {
        this.practiceDao.insert(practice);
        return practice;
    }

    /**
     * 修改数据
     *
     * @param practice 实例对象
     * @return 实例对象
     */
    @Override
    public Practice update(Practice practice) {
        this.practiceDao.update(practice);
        return this.queryById(practice.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.practiceDao.deleteById(id) > 0;
    }

    /**
     * 查询社会实践
     *
     * @param sid 学号
     * @return 社会实践信息
     */
    @Override
    public List<Practice> queryBysId(String sid) {
        return this.practiceDao.queryBysId(sid);
    }
}