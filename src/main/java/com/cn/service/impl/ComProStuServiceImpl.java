package com.cn.service.impl;

import com.cn.entity.ComProStu;
import com.cn.dao.ComProStuDao;
import com.cn.service.ComProStuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ComProStu)表服务实现类
 *
 * @author kai
 * @since 2018-11-28 15:54:35
 */
@Service("comProStuService")
public class ComProStuServiceImpl implements ComProStuService {
    @Resource
    private ComProStuDao comProStuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ComProStu queryById(Integer id) {
        return this.comProStuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ComProStu> queryAllByLimit(int offset, int limit) {
        return this.comProStuDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<ComProStu> all(){
        return this.comProStuDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param comProStu 实例对象
     * @return 实例对象
     */
    @Override
    public ComProStu insert(ComProStu comProStu) {
        this.comProStuDao.insert(comProStu);
        return comProStu;
    }

    /**
     * 修改数据
     *
     * @param comProStu 实例对象
     * @return 实例对象
     */
    @Override
    public ComProStu update(ComProStu comProStu) {
        this.comProStuDao.update(comProStu);
        return this.queryById(comProStu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.comProStuDao.deleteById(id) > 0;
    }

    /**
     * 查询竞标学生
     *
     * @param pid 项目ID
     * @return 竞标学生信息
     */
    @Override
    public List<ComProStu> queryStudentBypId(String pid) {
        return this.comProStuDao.queryStudentBypId(pid);
    }

    /**
     * 学号查询项目ID
     *
     * @param sid 学号
     * @return 所有相关ID
     */
    @Override
    public List<Integer> queryPidBySid(String sid) {
        return this.comProStuDao.queryPidBySid(sid);
    }


}