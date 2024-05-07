package com.programmer.basic.ioc.impl;

import com.programmer.basic.ioc.ParentService;


public class ParentServiceImpl implements ParentService {

    @Override
    public String hello() {
        return "Hello ParentService";
    }
}
