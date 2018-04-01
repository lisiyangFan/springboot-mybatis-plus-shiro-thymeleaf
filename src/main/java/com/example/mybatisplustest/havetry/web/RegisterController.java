

package com.example.mybatisplustest.havetry.web;


import com.example.mybatisplustest.havetry.entity.SysUsers;
import com.example.mybatisplustest.havetry.service.ISysUsersService;
import com.example.mybatisplustest.util.PasswordUtil;
import com.example.mybatisplustest.vo.SystemResult;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

  @Autowired
  private ISysUsersService sysUsersService;

  @RequestMapping("/register.do")
  public SystemResult Register(
      @Param("username") String username,
      @Param("password") String password,
      HttpServletRequest request) {

    System.out.println("进入到注册操作");
    SysUsers sysUsers = PasswordUtil.encryptPassword(username, password);

    boolean result = sysUsersService.insert(sysUsers);
    if (result) {
      request.getSession().setAttribute("username", username);
      request.getSession().setAttribute("password", password);
      return SystemResult.isOk();
    } else {
      return SystemResult.result("注册失败", 202);
    }
  }
}





