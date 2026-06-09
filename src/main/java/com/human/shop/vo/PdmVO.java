package com.human.shop.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PdmVO {
    private long id;
    private String category;
    private String name;
    private int price;
    private int stock;
    private String status;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;

}
