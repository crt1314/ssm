package com.chrt.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 邮箱类
 */
@Data
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邮箱唯一标识
     */
    private Integer id;
    /**
     * 邮箱信息
     */
    private String email;
}
