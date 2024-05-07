package com.programmer.answers.basic.ioc.impl;

import com.programmer.answers.basic.ioc.ParentService;

/**
 * Vous devez ajouter l'annotation @Service
 */
public class ParentServiceImpl implements ParentService {

    @Override
    public String hello() {
        return "Hello ParentService";
    }
}
