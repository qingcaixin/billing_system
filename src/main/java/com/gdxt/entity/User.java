package com.gdxt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WangXin
 * @Date 2023/6/13 14:09
 */

/**
 *  mybatis 整合测试demo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String pwd;
}
