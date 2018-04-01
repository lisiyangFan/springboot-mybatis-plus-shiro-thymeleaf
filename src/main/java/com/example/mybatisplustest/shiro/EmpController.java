/*
package com.example.mybatisplustest.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.mybatisplustest.havetry.entity.Emp;
import com.example.mybatisplustest.havetry.service.IEmpService;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


*/
/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lisiyang
 * @since 2018-03-18
 *//*

@RestController
@RequestMapping("/havetry/emp")
public class EmpController {

    @Autowired
   private private IEmpService empService;

    */
/**
     * 分页
     *
     * @return
     *//*

    @GetMapping("/page")
    public Page<Emp> forPage() {
        return empService.selectPage(new Page<Emp>(0, 5));
    }

    */
/**
     *条件分页
     * @param wrapper
     * @return
     *//*

    @GetMapping("/selectBy")
    public Page<Emp> selectBy(EntityWrapper<Emp> wrapper) {
        wrapper.setEntity(new Emp());
        String Condition1 = "A";
        //current 当前页码  size每页显示多少
        Page<Emp> page = new Page<>(2, 3);
        int deptno = 10;
        wrapper.like("ENAME", Condition1)
                .gt("DEPTNO", deptno);
        return empService.selectPage(page, wrapper);
    }

    @RequestMapping("/selectCount")
    public int selectCount(EntityWrapper<Emp> wrapper) {
        wrapper.setEntity(new Emp());
        Integer DEPTNO = 10;
        wrapper.where("DEPTNO = {0}", DEPTNO);
        Integer a = empService.selectCount(wrapper);
        System.out.println("count:  " + a);
        return a;
    }

    @RequestMapping("/selectList")
    public List<Emp> selectList(EntityWrapper<Emp> wrapper) {
        wrapper.setEntity(new Emp());
        int EMPNO = 7369;
        int DEPTNO = 10;
        wrapper.where("EMPNO > {0}", EMPNO).andNew("DEPTNO > {0}", DEPTNO).orderBy("EMPNO");
        List<Emp> list = empService.selectList(wrapper);
        return list;
    }

    @RequestMapping("/selectById")
    public Emp selectById(@Param("EMPNO") String EMPNO) {

        System.err.println(empService.selectById(EMPNO));
        return empService.selectById(EMPNO);
    }

}

*/
