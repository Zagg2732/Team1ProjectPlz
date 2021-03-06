package com.team1.sj.service;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.action.Action;
import com.team1.action.ActionForward;
import com.team1.sj.dao.SJ_board_dao;
import com.team1.sj.dto.SJ_Board_Reply;
import com.team1.sj.dto.SJ_board;

public class SJ_HumorContent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		SJ_board board = null;
		
		List<SJ_Board_Reply> replyList = null;
		
		try {
			String idx = request.getParameter("idx");
			String type = request.getParameter("type");
							
			String replyType = null;
			
			if(type.equals("humor_board")) {
				replyType = "humor_reply";
			} else if (type.equals("notice_board")) {
				replyType = "notice_reply";
			} else {
				replyType = "";
				System.out.println("replyType 설정 오류발생");
			}
					
			SJ_board_dao dao = new SJ_board_dao();
			boolean readnumAdd = dao.getReadNum(idx, type); //조회수증가
			
			
			board = dao.getContentDetails(idx, type); //DB에서 게시판 상세보기 정보 받아옴		
			replyList = dao.getReplyList(idx, replyType); //DB에서 해당 게시글 댓글목록 받아옴
			
			request.setAttribute("board", board); //게시자 정보			
			request.setAttribute("idx", idx); //글번호
			request.setAttribute("replyList", replyList); //리플
			
			
			forward = new ActionForward();
			forward.setRedirect(false);
			
			
			if(type.equals("humor_board")) {
				forward.setPath("/WEB-INF/views/sj/board_content/humor_board_content.jsp");
			} else if (type.equals("notice_board")) {
				forward.setPath("/WEB-INF/views/sj/board_content/notice_board_content.jsp");
			} else {
				System.out.println("Path error!");
			}
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
