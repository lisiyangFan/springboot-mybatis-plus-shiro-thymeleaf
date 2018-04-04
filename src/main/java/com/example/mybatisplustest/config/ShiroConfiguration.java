
package com.example.mybatisplustest.config;


import com.example.mybatisplustest.shiro.MyRealm;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {


  /**
   * ShiroFilterFactoryBean 处理拦截资源文件问题。 注意：单独一个ShiroFilterFactoryBean配置是会报错的，因为在
   * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
   *
   * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过 3、部分过滤器可指定参数，如perms，roles
   */

  @Bean
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    System.out.println("ShiroConfiguration.shirFilter()");
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    //必须设置SecurityManager
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    //如果不设置默认会自动寻找web工程根目录下的"/login.jsp"页面
    shiroFilterFactoryBean.setLoginUrl("/");
    //登录成功后要跳转的连接
    shiroFilterFactoryBean.setSuccessUrl("/mPage");
    //未授权界面
    shiroFilterFactoryBean.setUnauthorizedUrl("/403");
    // 拦截器.
    Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
    // 配置不会被拦截的链接 顺序判断
    filterChainDefinitionMap.put("/bootstrap-datetimepicker-master/**", "anon");
    filterChainDefinitionMap.put("/bootstrap_3.3.0/**", "anon");
    filterChainDefinitionMap.put("/images/**", "anon");
    filterChainDefinitionMap.put("/JQ/**", "anon");
    filterChainDefinitionMap.put("/addUserPage", "anon");
    filterChainDefinitionMap.put("/swagger-ui.html", "anon");
    //filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
//    filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/css/**", "anon");
//    filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/lib/**", "anon");
//    filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/lang/**", "anon");
//    filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/images/**", "anon");
//    filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/fonts/**", "anon");
//    filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/*.js", "anon");
    filterChainDefinitionMap.put("/webjars/**", "anon");
    filterChainDefinitionMap.put("/swagger-resources/**", "anon");
    filterChainDefinitionMap.put("/v2/**", "anon");

    filterChainDefinitionMap.put("/login.do", "anon");
    filterChainDefinitionMap.put("/register.do", "anon");

    // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
    filterChainDefinitionMap.put("/logout", "logout");

    //配置某个url需要某个权限码
    // filterChainDefinitionMap.put("/mPage", "roles[aaa]");

    // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
    // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
    //filterChainDefinitionMap.put("/", "user");
    filterChainDefinitionMap.put("/**", "authc");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    System.out.println("Shiro拦截器工厂类注入成功");
    return shiroFilterFactoryBean;
  }

  @Bean
  public SecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

    //设置realm
    securityManager.setRealm(myRealm());

    return securityManager;
  }

  @Bean
  public MyRealm myRealm() {
    MyRealm myRealm = new MyRealm();
    //使用HashedCredentialsMatcher实现密码验证服务
    HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher("md5");
    credentialsMatcher.setHashIterations(2);
    credentialsMatcher.setStoredCredentialsHexEncoded(true);
    myRealm.setCredentialsMatcher(credentialsMatcher);
    return myRealm;
  }

}