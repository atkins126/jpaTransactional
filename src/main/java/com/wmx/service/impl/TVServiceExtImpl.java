package com.wmx.service.impl;

import com.wmx.repository.TVRepository;
import com.wmx.service.TVServiceExt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TVServiceExtImpl implements TVServiceExt {
    @Resource
    private TVRepository tvRepository;

    //REQUIRES_NEW：表示新开一个事务，如果当前已经有事务，则会暂停
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteByIdExt(int id) {
        tvRepository.deleteById(id);
    }
}
