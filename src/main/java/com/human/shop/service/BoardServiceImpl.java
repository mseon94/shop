package com.human.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.shop.mapper.BoardMapper;
import com.human.shop.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
    // 컨트롤러에게 요청을 받으면 mapper에게 db작업
    // boardmapper를 의존
    // 그래서 boardmapper 객체의 주소가 필요

    @Autowired      // BoardMapper 타입 컨테이너로부터 주소를 주입 받는 역할
    private BoardMapper boardMapper;
    
    // 글 저장기능
    @Override
    public void insertBoard(BoardVO boardVo) {  
        boardMapper.insertBoard(boardVo);
        // throw new UnsupportedOperationException("Unimplemented method 'insertBoard'");
    }

    @Override
    public List<BoardVO> getBoardList() {
        // 컨트롤러로부터 리스트를 달라고 서비스 요청받음
        // 데이터베이스 작업 책임이 없음
        // mapper에게 다시 요청
        List<BoardVO> boardlist = boardMapper.selectBoardList();
        return boardlist;
    }

     @Override
    public void deleteBoard(Long id) {
        System.out.println("Service : 삭제 요청 처리");
        // 컨트롤러 요청의 처리, 매퍼에게 요청. 컨트롤러에게 응답(리턴)
        // 컨셉을 데이터베이스에 삭제하기 전에 암호를 입력했는가? 체크
        // 수업에서는 바로 데이터베이스 삭제하는 방밥으로 진행

        // 매퍼에게 요청
        // 매퍼 요청까지 끝나면 서비스에게 리턴 필요? -> ㄴㄴ. 삭제하고 끝. 리턴타입 void
        boardMapper.deleteById(id);
    }

    @Override
    public BoardVO detailBoard(Long id) {
        // BoardVO boardVo = boardMapper.getBoardById(id);
        return boardMapper.getBoardById(id);
    }

    @Override
    public void updateBoard(BoardVO boardVo) {
        boardMapper.updateById(boardVo);
    }

}
