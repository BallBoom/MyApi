package com.cn.service.impl;

import com.cn.entity.ComJobStu;
import com.cn.dao.ComJobStuDao;
import com.cn.service.ComJobStuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ComJobStu)表服务实现类
 *
 * @author kai
 * @since 2018-11-29 11:55:23
 */
@Service("comJobStuService")
public class ComJobStuServiceImpl implements ComJobStuService {
    @Resource
    private ComJobStuDao comJobStuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<ComJobStu> queryByPId(Integer id) {
        return this.comJobStuDao.queryByPId(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ComJobStu> queryAllByLimit(int offset, int limit) {
        return this.comJobStuDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<ComJobStu> all(){
        return this.comJobStuDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param comJobStu 实例对象
     * @return 实例对象
     */
    @Override
    public ComJobStu insert(ComJobStu comJobStu) {
        this.comJobStuDao.insert(comJobStu);
        return comJobStu;
    }

    /**
     * 修改数据
     *
     * @param comJobStu 实例对象
     * @return 实例对象
     */
//    @Override
//    public ComJobStu update(ComJobStu comJobStu) {
//        this.comJobStuDao.update(comJobStu);
//        return this.queryByPId(comJobStu.getId());
//    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.comJobStuDao.deleteById(id) > 0;
    }
}