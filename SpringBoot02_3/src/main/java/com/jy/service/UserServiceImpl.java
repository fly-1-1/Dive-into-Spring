package com.jy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.entity.User;
import com.jy.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //private final UserMapper userMapper;

    //@Autowired
    //private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Override
    public List<User> findAll() {
        return list();

    }

    public void saveUser(User user) {
        log.debug("姓名:{}", user.getName());
        save(user);
    }
}
