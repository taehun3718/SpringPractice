package com.ktds.christof_kim.board.dao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ktds.christof_kim.board.vo.ArticleVO;

//스프링이 제공하는 JUNIT클래스
//테스트 클래스가 실행될 때 제일 먼저 로딩된다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/spring/dispatcherServlet.xml"})
public class TestBoardDAOImpl {
	
	int id;	//test할 읽은 게시글의 id 
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Before
	public void setUp() {
		this.id = -1;
	}
	
	@After
	public void tearDown() {
		//게시글 삭제
		boardDAO.deleteArticleById(this.id);
	}
	
	@Test
	public void testWriteArticle(){
		
		ArticleVO articleVO = new ArticleVO();
		//게시글을 적었다고 가정
		articleVO.setId(0);
		articleVO.setSubject("aa");
		articleVO.setContent("a");
		
		//게시글을 적고 나서 해당 게시글이 맞는지 확인
		this.id = boardDAO.writeArticle(articleVO);
		ArticleVO vo = boardDAO.readArticleById(id);
		
		//게시글은 읽을때 절때 널이 있으면 안됨
		Assert.notNull(vo);

		//쓴 게시글과, 읽은 게시글이 맞는지 확인. 맞아야 함.. 틀리면 클남.
		Assert.isTrue(articleVO.getSubject().equals(vo.getSubject()));
		Assert.isTrue(articleVO.getContent().equals(vo.getContent()));
	}
}
