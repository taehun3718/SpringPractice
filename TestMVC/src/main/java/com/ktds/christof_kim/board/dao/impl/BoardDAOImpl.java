package com.ktds.christof_kim.board.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.christof_kim.board.dao.BoardDAO;
import com.ktds.christof_kim.board.vo.ArticleVO;

public class BoardDAOImpl implements BoardDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@Override
	public int writeArticle(ArticleVO articleVO) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
							,"KTH", "3278");
			
			String query = " INSERT INTO ARTICLE (ID, SUBJECT, CONTENT) ";
			query += "VALUES (ARTICLE_SEQ.NEXTVAL, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, articleVO.getSubject());
			pstmt.setString(2, articleVO.getContent());
			pstmt.execute();
			
			pstmt.close();
			
			query = "SELECT ARTICLE_SEQ.CURRVAL FROM DUAL ";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			return rs.getInt(1);
			
		}
		catch(SQLException sqle){
			throw new RuntimeException(sqle.getMessage(), sqle);
		}
		finally{
			if(rs!=null) {
				try {
					rs.close();
				} 
				catch (SQLException e) {}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public ArticleVO readArticleById(int id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try{
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
							,"KTH", "3278");
			
			String query = " SELECT ID, SUBJECT, CONTENT FROM ARTICLE WHERE ID = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			ArticleVO articleVO = null;
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				articleVO = new ArticleVO();
				articleVO.setId(rs.getInt(1));
				articleVO.setSubject(rs.getString(2));
				articleVO.setContent(rs.getString(3));
				
				
			}
			return articleVO;
		}
		catch(SQLException sqle){
			throw new RuntimeException(sqle.getMessage(), sqle);
		}
		finally{
			if(rs!=null) {
				try {
					rs.close();
				} 
				catch (SQLException e) {}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public List<ArticleVO> getAllArticleList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try{
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
							,"KTH", "3278");
			
			String query = " SELECT ID, SUBJECT, CONTENT FROM ARTICLE ";
			
			pstmt = conn.prepareStatement(query);
			
			List<ArticleVO> articleList = new ArrayList<ArticleVO>();
			ArticleVO articleVO = null;
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				articleVO = new ArticleVO();
				articleVO.setId(rs.getInt(1));
				articleVO.setSubject(rs.getString(2));
				articleVO.setContent(rs.getString(3));
				
				articleList.add(articleVO);
			}
			return articleList;
		}
		catch(SQLException sqle){
			throw new RuntimeException(sqle.getMessage(), sqle);
		}
		finally{
			if(rs!=null) {
				try {
					rs.close();
				} 
				catch (SQLException e) {}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void deleteArticleById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try{
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
							,"KTH", "3278");
			
			String query = " DELETE FROM ARTICLE WHERE ID = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			pstmt.execute();
		}
		catch(SQLException sqle){
			throw new RuntimeException(sqle.getMessage(), sqle);
		}
		finally{
			if(rs!=null) {
				try {
					rs.close();
				} 
				catch (SQLException e) {}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	@Override
	public void updateArticle(ArticleVO articleVO) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try{
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
							,"KTH", "3278");
			
			String query = " UPDATE ARTICLE SET SUBJECT = ?, CONTENT = ? WHERE ID = ? ";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, articleVO.getSubject());
			pstmt.setString(2, articleVO.getContent());
			pstmt.setInt(3, articleVO.getId());
			
			pstmt.execute();
		}
		catch(SQLException sqle){
			throw new RuntimeException(sqle.getMessage(), sqle);
		}
		finally{
			if(rs!=null) {
				try {
					rs.close();
				} 
				catch (SQLException e) {}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

}
