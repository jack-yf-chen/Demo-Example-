package com.example.mapper;

import com.example.entity.RoleEntity;

import java.util.List;

public interface RoleMapper {

    List<RoleEntity> getRolesByUserId(Long userId);

}
