package com.human.shop.vo;

import java.time.LocalDateTime;

public class BoardVO {

    // 게시글 번호
    private Long id;

    // 작성자
    private String writer;

    // 제목
    private String title;

    // 내용
    private String content;

    // 조회수
    private int viewCount;

    // 작성일
    private LocalDateTime createdAt;

    // 수정일
    private LocalDateTime updatedAt;

    // 삭제 여부
    private boolean deleted;

    // 기본 생성자
    public BoardVO() {
    }

    // getter
    public Long getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getViewCount() {
        return viewCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", viewCount=" + viewCount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deleted=" + deleted +
                '}';
    }
}