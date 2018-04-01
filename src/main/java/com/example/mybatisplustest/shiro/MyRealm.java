
package com.example.mybatisplustest.shiro;

import com.example.mybatisplustest.havetry.entity.SysUsers;
import com.example.mybatisplustest.havetry.service.ISysUsersService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SocketUtils;

public class MyRealm extends AuthorizingRealm {

  @Autowired
  private ISysUsersService sysUsersService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

/*
    String userName = (String) principalCollection.getPrimaryPrincipal();
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
    simpleAuthorizationInfo.addRoles(sysUsersService.selectRoles(userName));
*/

    return null;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
      throws AuthenticationException {
    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    String userName = (String) token.getPrincipal();

    SysUsers sysUsers = sysUsersService.selectUsersByUserName(userName);
    System.err.println("------------------------" + sysUsers);
    if (sysUsers == null) {
      throw new UnknownAccountException();//没找到帐号
    }

    if ((sysUsers.getLocked()) == 1) {
      throw new LockedAccountException(); //帐号锁定
    }

    SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
        userName, sysUsers.getPassword(), ByteSource.Util.bytes(sysUsers.getSalt()), getName());
    return simpleAuthenticationInfo;
  }
}

