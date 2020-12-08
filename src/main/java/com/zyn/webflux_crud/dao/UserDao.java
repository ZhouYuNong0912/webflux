package com.zyn.webflux_crud.dao;

import com.zyn.webflux_crud.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @Author: zyn
 * @Create: 2020-12-07 16:12
 * @Description:
 **/
public interface UserDao extends ReactiveCrudRepository<User,Integer> {

}
