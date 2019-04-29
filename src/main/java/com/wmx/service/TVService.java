package com.wmx.service;

import com.wmx.entity.TV;

import java.util.List;

public interface TVService {

    //查询所有
    List<TV> findAll();

    //保存或更新
    void save(TV tv);

    //根据主键 tvId 删除
    void deleteById(int id);
}
