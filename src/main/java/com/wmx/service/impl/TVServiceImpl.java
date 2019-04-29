package com.wmx.service.impl;

import com.wmx.entity.TV;
import com.wmx.repository.TVRepository;
import com.wmx.service.TVService;
import com.wmx.service.TVServiceExt;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TVServiceImpl implements TVService {
    @Resource
    private TVRepository tvRepository;

    @Resource
    private TVServiceExt tvServiceExt;

    @Override
    public List<TV> findAll() {
        //查询所有数据，并以主键 tvId 倒序排序
        return tvRepository.findAll(Sort.by(Sort.Direction.DESC, "tvId"));
    }

    //org.springframework.transaction.annotation.Transactional：事务管理
    //@Transactional 添加到哪个方法上，哪个方法就会进行事务管理.默认传播特性为REQUIRED
    @Override
    @Transactional
    public void save(TV tv) {
        tvServiceExt.deleteByIdExt(10);//调用其它类中的方法

        //故意制造一个数组下标越界异常，典型的运行时异常
        System.out.println("123".split(",")[1]);
        tv.setTvName(tv.getTvName() + "_xxx");
        tvRepository.save(tv);
    }

    @Override
    public void deleteById(int id) {
        tvRepository.deleteById(id);
    }
}
