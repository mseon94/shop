package com.human.shop.service;

import java.util.List;

import com.human.shop.vo.BoardVO;

public interface BoardService {
    void insertBoard(BoardVO boardVo);
    // mapper 인터페이스는 구현체가 없어도 된다.
    // 마이바티스가 알아서 처리
    // 서비스단은 인터페이스와 구현체가 짝꿍이 되어야 함
    // 구현체를 하나 만든다

    List<BoardVO> getBoardList();

    // 삭제에 대한 서비스를 정의
    void deleteBoard(Long id);

    // 글 자세히 보기 서비스
    BoardVO detailBoard(Long id);

    // 수정
    void updateBoard(BoardVO boardVo);
}
