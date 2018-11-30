package com.cn.service;

import com.cn.entity.User;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author kai
 * @since 2018-11-17 18:05:05
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);


    /**
    * 无条件查询全部数据
    * @return 对象列表
    */
    List<User> all();
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 登录操作
     * @param phone 手机号
     * @param pw 密码
     * @return 对象
     */
    int login(String phone,String pw);

    /**
     * 检查手机号
     * @param phone 手机号
     * @return 对象
     */
    boolean checkPhone(String phone);

    /**
     * 检查用户名
     * @param username 用户名
     * @return 对象
     */
    boolean checkUsername(String username);

    /**
     * 查询用户所有信息
     * @param phone 手机号
     * @return 用户信息
     */
    User queryByPhone(String phone);

}