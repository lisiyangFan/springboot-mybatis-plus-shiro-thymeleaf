package com.example.mybatisplustest.havetry.service;

import com.example.mybatisplustest.havetry.entity.SysUsers;
import com.baomidou.mybatisplus.service.IService;
import java.util.Collection;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lisiyang
 * @since 2018-03-31
 */
public interface ISysUsersService extends IService<SysUsers> {
  /**
   * 过用户名查询用户
   * @param username
   * @return
   */
  SysUsers selectUsersByUserName(String username);

  Set<String> selectRoles(String userName);

  Set<String> selectPermission(String userName);
}
