package com.cn.service.impl;

import com.cn.entity.StudentInfo;
import com.cn.dao.StudentInfoDao;
import com.cn.service.StudentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (StudentInfo)表服务实现类
 *
 * @author kai
 * @since 2018-11-23 00:14:44
 */
@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService {
    @Resource
    private StudentInfoDao studentInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StudentInfo queryById(Integer id) {
        return this.studentInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<StudentInfo> queryAllByLimit(int offset, int limit) {
        return this.studentInfoDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<StudentInfo> all(){
        return this.studentInfoDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param studentInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StudentInfo insert(StudentInfo studentInfo) {
        this.studentInfoDao.insert(studentInfo);
        return studentInfo;
    }

    /**
     * 修改数据
     *
     * @param studentInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int update(StudentInfo studentInfo) {
        return this.studentInfoDao.update(studentInfo);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.studentInfoDao.deleteById(id) > 0;
    }

    /**
     * @param phone 手机号
     * @return 对象
     */
    @Override
    public StudentInfo queryStudent(String phone) {
        return this.studentInfoDao.queryStudent(phone);
    }
}