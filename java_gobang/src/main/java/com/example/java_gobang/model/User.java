/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/6 21:11
 * @Version 1.0
 */
package com.example.java_gobang.model;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String username;
    private String password;
    private int score;
    private int totalCount;
    private int winCount;
}
