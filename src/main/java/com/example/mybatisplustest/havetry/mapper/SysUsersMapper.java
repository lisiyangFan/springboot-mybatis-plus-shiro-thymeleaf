package com.example.mybatisplustest.havetry.mapper;

import com.example.mybatisplustest.havetry.entity.SysUsers;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.Set;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p> Mapper 接口 </p>
 *
 * @author lisiyang
 * @since 2018-03-31
 */
public interface SysUsersMapper extends BaseMapper<SysUsers> {

  /**
   * 通过用户名查询用户
   */
  //@Select("select * FROM sys_users where username=#{username}")
  SysUsers selectUsersByUserName(@Param("username") String username);

  Set<Integer> selectRoleByUserId(Integer userId);

  String selectRolesByRoleId(Integer roleId);
}
