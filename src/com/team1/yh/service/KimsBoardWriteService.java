package com.team1.yh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.action.Action;
import com.team1.action.ActionForward;

public class KimsBoardWriteService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
ActionForward forward = null;
		
		try {
			forward = new ActionForward();
			forward.setRedirect(false); // forward
			forward.setPath("/WEB-INF/views/yh/board_kims/boardwrite.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
