package com.cn.service.impl;

import com.cn.entity.User;
import com.cn.dao.UserDao;
import com.cn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author kai
 * @since 2018-11-17 18:05:05
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }
    
      /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<User> all(){
        return this.userDao.all();
    }
    

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(User user) {
        return this.userDao.insert(user);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int update(User user) {
        return this.userDao.update(user);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    /**
     * 登录
     * @param phone 手机号
     * @param pw 密码
     * @return 登录信息
     */
    @Override
    public int login(String phone, String pw) {
        User user= this.userDao.login(phone);
        System.out.println(user.toString());
        boolean truePhone=phone.equals(user.getUPhone());
        boolean truePw=pw.equals(user.getUPassword());
        System.out.println(truePhone+","+truePw);
        if(user==null){
            return 0;
        }else if (truePhone && truePw && user.getRoleId()==1){
            return 1;
        }else if(truePhone && truePw && user.getRoleId()==2){
            return 2;
        }else{
            return -1;
        }

    }

    /**
     * 检查手机号
     * @param phone 手机号
     * @return 是否正确
     */
    @Override
    public boolean checkPhone(String phone) {
        User user=this.userDao.checkPhone(phone);
        if(user!=null){ return true;}
        return false;
    }

    /**
     * 检查用户名
     * @param username 用户名
     * @return 是否正确
     */
    @Override
    public boolean checkUsername(String username) {
        User user=this.userDao.checkUsername(username);
        if(user!=null){ return true; }
        return false;
    }

    /**
     * 查询用户所有信息
     *
     * @param phone 手机号
     * @return 用户信息
     */
    @Override
    public User queryByPhone(String phone) {
        return this.userDao.queryByPhone(phone);
    }
}