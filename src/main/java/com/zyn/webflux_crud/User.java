package com.zyn.webflux_crud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author: zyn
 * @Create: 2020-12-07 16:10
 * @Description:
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table("user")
public class User {

    @Id
    private Integer id;

    private String name;

    private Integer age;

    private String email;
}
