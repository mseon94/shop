package com.human.shop.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SupportVO {
    private Long id;
    private String writer;
    private String email;
    private String password;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean completed;
    private boolean dedeted;
}
