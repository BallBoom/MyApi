package com.cn.service.impl;

import com.cn.entity.StuLetter;
import com.cn.dao.StuLetterDao;
import com.cn.service.StuLetterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (StuLetter)表服务实现类
 *
 * @author kai
 * @since 2018-12-02 15:40:08
 */
@Service("stuLetterService")
public class StuLetterServiceImpl implements StuLetterService {
    @Resource
    private StuLetterDao stuLetterDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StuLetter queryById(Integer id) {
        return this.stuLetterDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<StuLetter> queryAllByLimit(int offset, int limit) {
        return this.stuLetterDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<StuLetter> all(){
        return this.stuLetterDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param stuLetter 实例对象
     * @return 实例对象
     */
    @Override
    public StuLetter insert(StuLetter stuLetter) {
        this.stuLetterDao.insert(stuLetter);
        return stuLetter;
    }

    /**
     * 修改数据
     *
     * @param stuLetter 实例对象
     * @return 实例对象
     */
    @Override
    public StuLetter update(StuLetter stuLetter) {
        this.stuLetterDao.update(stuLetter);
        return this.queryById(stuLetter.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.stuLetterDao.deleteById(id) > 0;
    }

    /**
     * 学生查询推荐信
     *
     * @param sid 学号
     * @return 推荐信
     */
    @Override
    public StuLetter queryLetter(String sid) {
        return this.stuLetterDao.queryLetter(sid);
    }
}