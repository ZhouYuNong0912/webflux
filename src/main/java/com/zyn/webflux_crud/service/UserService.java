package com.zyn.webflux_crud.service;

import com.zyn.webflux_crud.User;
import com.zyn.webflux_crud.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author: zyn
 * @Create: 2020-12-07 16:15
 * @Description:
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Mono<User> save(User user) {
        return userDao.save(user);
    }

    public Mono<User> find(Integer id) {
        return userDao.findById(id);
    }

    public Mono<Void> delete(Integer id) {
       //1、existsById判断是否存在数据，不存在返回false,存在返回ture
       //2、在flatMap中再根据Boolean类型进行逻辑处理
       return userDao.existsById(id).flatMap(i -> {
            if (i) {
                return userDao.deleteById(id);
            }
            return Mono.empty();
        });
    }

    public Flux<User> findAll() {
        return userDao.findAll();
    }
}
