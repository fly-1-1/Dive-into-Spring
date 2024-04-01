package com.jy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param1")
public class Param1Controller {

    /*RequestMapping 第一个作用
    * 客户端必须提交全部参数
    * */
    @RequestMapping("/param1")
    public String m1(@RequestParam("n")String name,@RequestParam("p")String password){
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }


    /*RequestMapping 第二个作用
     *不接受POJO
     * */
    @RequestMapping("/param2")
    public String m2(@RequestParam User user){
        System.out.println("user = " + user);
        return "param1";
    }

    /*RequestMapping 第三个作用
     * */
    @RequestMapping("/param3")
    public String m3(@RequestParam("id<")Integer id){
        System.out.println("id = " + id);
        return "param1";
    }

    /*RequestMapping 第四个作用
      required属性 true ->客户端必须提交对应参数
     * */
    @RequestMapping("/param4")
    public String m4(@RequestParam String name,@RequestParam(required = false) String password){

        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }

    /*RequestMapping 第五个作用
     defaultValue
    * */
    @RequestMapping("/param5")
    public String m5(@RequestParam String name,@RequestParam(defaultValue = "321") String password){

        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }



}
