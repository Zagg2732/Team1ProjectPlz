package com.team1.sy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.team1.sj.dto.SJ_board;
import com.team1.sy.dto.Member;

public class AdminPostDao {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	public AdminPostDao() {
		try{
			Context init = new InitialContext();
	  		ds = 
	  			(DataSource) init.lookup("java:comp/env/jdbc/oracle");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
		
	}
	
	//회원 목록보기
		public List<SJ_board> sjBoardBestList(String boardName, int pagesize){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<SJ_board> list = null;
			try {
				conn = ds.getConnection();
				String sql = "SELECT IDX , NICKNAME , UP , DOWN , READNUM , WRITEDATE , SUBJECT FROM (SELECT * FROM "
								+ boardName + 
								" bn LEFT JOIN TEAM1_USER tu ON bn.USERID_FK = tu.USERID ORDER BY up DESC) WHERE rownum <= ?";
				
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, pagesize);
				
				rs = pstmt.executeQuery();
				list = new ArrayList<SJ_board>();
				while(rs.next()) {
					
					SJ_board board = new SJ_board();
					
					board.setIdx(rs.getInt("IDX"));
					board.setNickname(rs.getString("NICKNAME"));
					board.setUp(rs.getInt("UP"));
					board.setDown(rs.getInt("DOWN"));
					board.setReadnum(rs.getInt("READNUM"));
					board.setWritedate(rs.getDate("WRITEDATE"));
					board.setSubject(rs.getString("SUBJECT"));
					
					list.add(board);
				}
				
			}catch (Exception e) {
				System.out.println("오류 :" + e.getMessage());
			}finally {
				try {
					pstmt.close();
					rs.close();
					conn.close();//반환
				} catch (Exception e2) {
					
				}
			}
			return list;
		}
	
	// 회원 총 건수 구하기
	public int totalUserCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalUserCnt = 0;
		try {
			conn = ds.getConnection(); // dbcp 연결객체 얻기
			String sql = "select count(*) cnt from TEAM1_USER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalUserCnt = rs.getInt("cnt");
			}
		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();// 반환 connection pool 에 반환하기
			} catch (Exception e) {

			}
		}
		return totalUserCnt;
	}

}
