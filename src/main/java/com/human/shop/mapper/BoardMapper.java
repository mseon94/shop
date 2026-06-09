package com.human.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.human.shop.vo.BoardVO;

// Mapper는 interface 사용해야 함
@Mapper
public interface BoardMapper {      // BoardMapper.xml의 namespace의 주소와 같음
    public void insertBoard(BoardVO boardVo);
    
    List<BoardVO> selectBoardList();

    // 삭제요청 - id를 조건으로 삭제하겠다
    void deleteById(Long id);

    // 글 상세보기 : id로 튜플 하나 가져오기
    BoardVO getBoardById(Long id);

    // 수정
    void updateById(BoardVO boardVo);
}


