package com.zyn.webflux_crud.config;

/**
 * @Author: zyn
 * @Create: 2020-12-07 16:26
 * @Description:
 **/
public class RouterPath {

    public static final String root = "/router/user";
    public static final String save = root + "/save";
    public static final String find = root + "/find/{id}";
    public static final String update = root + "/update/{id}";
    public static final String delete = root + "/delete/{id}";
    public static final String findAll = root + "/findAll";

}
