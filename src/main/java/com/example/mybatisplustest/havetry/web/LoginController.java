

package com.example.mybatisplustest.havetry.web;


import com.example.mybatisplustest.vo.SystemResult;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @RequestMapping("/login.do")
  public SystemResult Login(
      @Param("username") String username,
      @Param("password") String password,
      HttpServletRequest request) {

    System.out.println("进入到登录操作");
    String msg = "";
    UsernamePasswordToken token = new UsernamePasswordToken(username, password);
    Subject subject = SecurityUtils.getSubject();
    try {
      subject.login(token);
      request.getSession().setAttribute("username", username);
      request.getSession().setAttribute("password", password);
      return SystemResult.isOk();
    } catch (AuthenticationException exception) {
      if (UnknownAccountException.class.getName().equals(exception)) {
        System.out.println("UnknownAccountException -- > 用户名或密码错误：");
        msg = "用户名或密码错误：";
      } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
        System.out.println("IncorrectCredentialsException -- > 用户名或密码错误：");
        msg = "用户名或密码错误：";
      } else if (LockedAccountException.class.getName().equals(exception)) {
        System.out.println("kaptchaValidateFailed -- > 账户被锁定");
        msg = "账户被锁定";
      } else {
        msg = "else >> " + exception;
        System.out.println("其他错误" + exception);
      }
    }
    return SystemResult.result(msg, 201);
  }


  //登出
  @RequestMapping(value = "/logout")
  public String logout() {
    return "logout";
  }
}





