package com.example.mybatisplustest.havetry.service.impl;

import com.example.mybatisplustest.havetry.entity.SysUsers;
import com.example.mybatisplustest.havetry.mapper.SysUsersMapper;
import com.example.mybatisplustest.havetry.service.ISysUsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> 服务实现类 </p>
 *
 * @author lisiyang
 * @since 2018-03-31
 */
@Service
public class SysUsersServiceImpl extends ServiceImpl<SysUsersMapper, SysUsers> implements
    ISysUsersService {

  @Autowired
  private SysUsersMapper sysUsersMapper;

  @Override
  public SysUsers selectUsersByUserName(String username) {
    SysUsers sysUsers = sysUsersMapper.selectUsersByUserName(username);
    return sysUsers;
  }

  @Override
  public Set<String> selectRoles(String userName) {
    Set<String> rolesSet = new HashSet<String>();
    SysUsers sysUsers = sysUsersMapper.selectUsersByUserName(userName);

    Set<Integer> rolesId = sysUsersMapper.selectRoleByUserId(sysUsers.getId());
    for (Integer roleId : rolesId) {
      rolesSet.add(sysUsersMapper.selectRolesByRoleId(roleId));
    }
    return rolesSet;
  }
}
