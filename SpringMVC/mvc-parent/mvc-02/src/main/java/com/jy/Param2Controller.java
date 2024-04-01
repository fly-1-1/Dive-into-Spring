package com.jy;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("param2")
public class Param2Controller {

    /*单值动态参数*/
    @RequestMapping("param1")
    public String parma1(@RequestParam Map<String, String> params) {

        Set<String> keys = params.keySet();
        for (String key : keys) {
            System.out.println("key = " + key + " value = " + params.get(key));
        }
        return "param1";
    }
    /*多值动态参数*/
    @RequestMapping("param2")
    public String parma2(@RequestParam MultiValueMap<String,String>params) {

        Set<String> keys = params.keySet();
        for (String key : keys) {
            List<String> values = params.get(key);
            System.out.print("key: "+key+" value: ");
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
        return "param1";
    }
}
