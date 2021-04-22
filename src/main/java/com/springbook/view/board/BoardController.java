package com.springbook.view.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
}
