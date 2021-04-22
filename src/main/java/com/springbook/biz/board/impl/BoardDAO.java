package com.springbook.biz.board.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;


//DAO(Data Access Object)
@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 구문
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";	

	// 글 수정
	public void updateBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	// 글 등록
	public void insertBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

}
