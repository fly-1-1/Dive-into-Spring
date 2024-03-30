package com.jy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("mapping")
public class MappingController {

    /*默认接收所有请求方式访问*/
    @RequestMapping(value = "/m1",method = {RequestMethod.POST,RequestMethod.GET})
    public String m1(){
        System.out.println("MappingController.m1");
        return "/result.jsp";
    }


}
