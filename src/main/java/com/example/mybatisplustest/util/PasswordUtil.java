
package com.example.mybatisplustest.util;

import com.example.mybatisplustest.havetry.entity.SysUsers;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordUtil {


  /**
   * MD5 2次 使用随机数加用户名作为盐
   */

  public static SysUsers encryptPassword(String username, String password) {
    SysUsers sysUsers = new SysUsers();

    String algorithmName = "md5";//编码方式
    //用户名+随机数为盐
    String salt = username + new SecureRandomNumberGenerator().nextBytes().toHex();
    System.out.println("salt2 = " + salt);
    int hashIterations = 2;

    SimpleHash hash = new SimpleHash(algorithmName, password, salt, hashIterations);
    String encodedPassword = hash.toHex();
    sysUsers.setUsername(username);
    sysUsers.setPassword(encodedPassword);
    sysUsers.setSalt(salt);
    sysUsers.setLocked(0);
    System.out.println(sysUsers);
    return sysUsers;
  }
}

