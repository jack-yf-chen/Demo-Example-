package com.example.service;

import com.example.entity.UserEntity;
import com.example.factory.UserFactory;
import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 这里是数据库里的用户类
        UserEntity user = userMapper.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("没有该用户 '%s'.", username));
        } else {

            user.setRoles(roleMapper.getRolesByUserId(user.getId()));
            //这里返回上面继承了 UserDetails  接口的用户类,为了简单我们写个工厂类
            return UserFactory.create(user);
        }
    }
}
