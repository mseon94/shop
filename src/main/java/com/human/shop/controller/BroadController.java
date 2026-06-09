package com.human.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.human.shop.service.BoardService;
import com.human.shop.vo.BoardVO;


@Controller
public class BroadController {
    
    // BoardService에게 의존
    @Autowired  // 컨테이너로부터 주소 주입 받겠다
    private BoardService boardService;

    @GetMapping("/boards")
    public String getBoardList(Model model) {
        // 데이터베이스로부터 데이터를 가져오는 작업
        // 컨트롤러는 데이터베이스에서 자료를 가져오는 책임이 없다
        // 서비스 레이어에게 요청을 한다.
        List<BoardVO> boardlist = boardService.getBoardList();
        // 컨트롤러가 서비스에게 요청하고 서비스는 매퍼layer에게 요청
        // 컨트롤러가 그 데이터를 받음
        // 컨트롤러는 클라이언트 요청 매핑 > 서비스단> 뷰를 지정
        // 즉, boardlist를 뷰에게 넘김 : 필요한 객체 = 모델
        model.addAttribute("boardlist", boardlist);  // "변수명", 값 -> 일반적으로 똑같이 하지만 달라도 무방
        return "board/list";
    }
    
    @GetMapping("/boards/write")        // 클라이언트 요청 자원을 매핑해서 처리
    public String geBoardtWrite() {     // @RequestParam은 클라이언트가 보낸 파라미터를 받음 -> 여기선 필요 없어서 삭제
        return "board/write";           // 뷰 이름
    }
    
    @PostMapping("/boards")
    public String postBoard(@ModelAttribute BoardVO boardVo) {
        // @RequestParam 변수 한 개씩 받을 때 사용
        // @ModelAttribute vo 객체로 받는다.
        // 파라미터 변수명과 vo의 변수명이 같으면 자동으로 매핑해준다.
        // 글쓰기 화면에서 writer, title, content가 입력되면 세 개의 정보를 boardVo 변수로 받겠다 -> 예전 DTO 개념
        System.out.println(boardVo.toString());
        boardService.insertBoard(boardVo);
        System.out.println("디비 저장 성공");
        return "redirect:/boards";
    }

    @GetMapping("/boards/delete/{id}")     // {} : 파라미터 받음 -> 1개    Pathvariable 방식
    public String deleteBoard(@PathVariable("id") Long id) {    // "id"는 변수명으로 {}안과 같아야 하고 
                                                                // Long id는 변수명. 여기서 내가 지정하는건데 대부분 같게 함

        // 고민 : 서비스단에 요청해야 하는가? -> 3Layer 설계
        // 클라이언트는 글 삭제 요청 -> 데이터베이스 삭제 역할 = mapper
        // 극잔적으로 말하면 컨트롤러는 매퍼가 있는지도 몰라도 됨
        // 결론 : 서비스단에 요청 해야 한다.
        // 
        boardService.deleteBoard(id);
        return "redirect:/boards";  // 다시 리퀘스트 요청, 컨트롤러에게 요청. 뷰 이름이 아님
        // 고급스럽게 표현하자면 뷰 리졸브, 뷰 리졸브는 뷰의 이름으로 다시 요청하는 기능
        // 1. 리스트로 화면 바꾸기 : 틀린 답은 아님
        // 2. 역할을 추가 설명. 
        //    deleteBoard의 역할은 삭제의 역할이고 추후 보여 줄 화면은 boards 요청이 담당하고 있어서 redirect로 설정
        // + 뷰 리졸브는 redirect를 보고 다시 request를 요청함
    }
    
    @GetMapping("/boards/{id}")
    public String getMethodName(@PathVariable("id") Long id, Model model) {
        boardService.detailBoard(id);
        model.addAttribute("board", boardService.detailBoard(id));
        return "board/detail";
    }
    
    @GetMapping("/boards/edit/{id}")
    public String getBoardEdit(@PathVariable("id") long id, Model model) {
        model.addAttribute("board", boardService.detailBoard(id));
        return "board/edit";
    }
    
    @PostMapping("/boards/update")
    public String postMethodName(@ModelAttribute BoardVO boardVo) {
        boardService.updateBoard(boardVo);
        return "redirect:/boards";
    }
    

}
