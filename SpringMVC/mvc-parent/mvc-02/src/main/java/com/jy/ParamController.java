package com.jy;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {
    /*servlet api 接收请求参数*/
    @RequestMapping("param1")
    public String m1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }

    /*简单变量*/
    @RequestMapping("param2")
    public String m2(String name, String password) {
        System.out.println("name = " + name + ", password = " + password);
        return "param1";
    }

    /*简单变量的自动转换*/
    @RequestMapping("param3")
    public String m3(String name, Integer password) {
        System.out.println("name = " + name + ", password = " + password);
        return "param1";
    }

    /*POJO*/
    @RequestMapping("param4")
    public String m4(String name, User user) {
        System.out.println("name = " + name);
        System.out.println("user = " + user);
        return "param1";
    }

    /*接收一组简单变量*/
    @RequestMapping("param5")
    public String m5(int[] ids) {
        System.out.println("ids = " + Arrays.toString(ids));
        return "param1";
    }

    /*
    不能用接口类型接收参数,无法实例化
    按照成员变量查找时,形参匹配失效
    * */
    @RequestMapping("param6")
    public String m6(ArrayList<Integer> ids) {
        System.out.println("list ids = " + ids);
        return "param1";
    }

    @RequestMapping("param7")
    public String m7(UsersDto usersDto) {
        List<User> users = usersDto.getUsers();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        return "param1";
    }
}
