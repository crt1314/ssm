package com.chrt.ssm.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户类
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户唯一标识
     */
    private Integer id;
    /**
     * 用户账号
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private List<Email> emails;
}
