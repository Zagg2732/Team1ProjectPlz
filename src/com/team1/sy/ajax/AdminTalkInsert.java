package com.team1.sy.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.sy.dao.AdminTalkDao;
import com.team1.sy.dto.AdminTalk;

@WebServlet("/AdminTalkInsert.sooyeon")
public class AdminTalkInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminTalkInsert() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String userid = request.getParameter("userid");
    	String content = request.getParameter("content");
    	    	
    	try {
    		AdminTalkDao dao = new AdminTalkDao();
    		
    		AdminTalk talk = new AdminTalk();
    		
    		talk.setUserid_fk(userid);
    		talk.setContent(content);
    		
    		boolean result = dao.insertAdminTalk(talk);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
