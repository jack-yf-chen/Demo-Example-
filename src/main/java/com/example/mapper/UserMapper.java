package com.example.mapper;

import com.example.entity.UserEntity;

import java.util.List;

public interface UserMapper {

    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    int insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);

    UserEntity findByUserName(String userName);
}
