/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/5 20:56
 * @Version 1.0
 */
package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public UserInfo getUserById(Integer id){
        return userMapper.getUserById(id);
    }

}
