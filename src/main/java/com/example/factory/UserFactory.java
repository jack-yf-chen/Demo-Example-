package com.example.factory;

import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.stream.Collectors;

public class UserFactory {
    private UserFactory() {
    }

    public static UserEntity create(UserEntity user) {
        return new UserEntity(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList()))
        );
    }

    //将与用户类一对多的角色类的名称集合转换为 GrantedAuthority 集合
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
