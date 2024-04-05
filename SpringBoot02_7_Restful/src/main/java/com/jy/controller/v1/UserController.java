package com.jy.controller.v1;


import com.jy.entity.Pet;
import com.jy.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController  //@RestController =@Controller+@ResponseBody
//@Controller
@RequestMapping("/v1/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    //ResponseEntity springmvc响应类 这个类在响应时可以提供相应状态码,同事还可以自定义响应头信息


    //@RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
    //子类型注解 只能用Get方式访问到当前请求
    //@ResponseBody
    //将控制器返回的方法转为Json
    public ResponseEntity<User> user(@PathVariable("id") Integer id) {
        log.info("本次id: {}", id);
        //return new User(id, "小陈", 2300.23, new Date());
        User user = new User(id, "小陈", 2300.23, new Date());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    //@ResponseBody
    public ResponseEntity<List<User>> users() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(21, "小王", 2300.23, new Date()));
        users.add(new User(24, "小金豆", 3400.23, new Date()));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    //@ResponseBody
    //@RequestBody
    //接收请求中的json数据格式
    public ResponseEntity<Void> save(@RequestBody User user) {
        log.info("name:{} salary:{} bir:{}", user.getName(), user.getSalary(), user.getBir());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 更新用户
     *
     * @param user
     */
    @PutMapping("/{id}")
    //@ResponseBody
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody User user) {
        log.info("id:{} name:{} salary:{} bir:{}", id, user.getName(), user.getSalary(), user.getBir());
        //调用业务方法
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 删除用户信息
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    //@ResponseBody
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        log.info("本次id: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 获取这个人所有宠物
     */
    @GetMapping("/{id}/pets")
    public ResponseEntity<List<Pet>> pets(@PathVariable("id") Integer id) {
        log.info("查询哪个人id: {}", id);
        List<Pet> pets = Arrays.asList(new Pet(21, "小红帽", 23), new Pet(22, "小猪", 22));
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/{id}/pets/{pid}")
    public ResponseEntity<Pet> pet(@PathVariable("id") Integer id, @PathVariable("pid") Integer pid) {
        log.info("查询哪个人id: {}", id);
        //return new Pet(21, "小红帽", 23);
        Pet pet = new Pet(21, "小红帽", 23);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

}
