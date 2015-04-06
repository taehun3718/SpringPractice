package com.ktds.christof_kim.board.service;

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

//Dependency Injection이 필요한 경우 XML 설정 파일을 로딩한다.
//여러개의 설정파일을 로딩할 수 있다
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/spring/dispatcherServlet.xml"})
public class TestBoardServiceImpl {
	
	private int testWritedArticleId = 0;
	private int testWritedArticleId_forUpdate = 0;
	
	@Autowired
	private BoardService boardService;
	
	@Before
	public void setUp() {
		//System.out.println("Insert 테스트에 필요한 사전작업");
		//없심.
		//System.out.println("Delete 테스트에 필요한 사전작업");
		//System.out.println("Update 테스트에 필요한 사전작업");
		
		System.out.println("Setup 입니다. 테스트 실행 직전에 Setup이 실행됩니다.");
		
		ArticleVO articleVO = new ArticleVO();
		articleVO.setId(testWritedArticleId_forUpdate);
		
		articleVO.setSubject("업데이트 하기 전 제목입니다.");
		articleVO.setContent("업데이트 하지 전 내용입니다.");
		testWritedArticleId_forUpdate = boardService.writeArticle(articleVO);
		boardService.writeArticle(articleVO);
		
	}
	
	@After
	public void tearDown() {
		//System.out.println("Insert 테스트에 필요한 사후작업");
		boardService.deleteArticleById(testWritedArticleId);
		boardService.deleteArticleById(testWritedArticleId_forUpdate);
		//System.out.println("Delete 테스트에 필요한 사후작업");
		//System.out.println("Update 테스트에 필요한 사후작업");
		
		System.out.println("TearDown 입니다. 테스트 실행 직후에 TearDown이 실행됩니다. ");
	}

	@Test
	public void test1(){
	}
	
	@Test
	public void test2(){
	}
	
	@Test
	public void testWriteArticle() {
		ArticleVO articleVO = new ArticleVO();
		articleVO.setContent("테스트입니다. 내용이에여 ㅋㅋㅋㅋ");
		articleVO.setSubject("테스트입니다. 제목이에여 ㅋㅋㅋㅋ");
		
		testWritedArticleId = boardService.writeArticle(articleVO);
		ArticleVO article = boardService.readArticleById(testWritedArticleId);
		Assert.notNull(article);
		Assert.isTrue(article.getSubject().equals(articleVO.getSubject()));
		Assert.isTrue(article.getContent().equals(articleVO.getContent()));
	}
	
	@Test(expected=NullPointerException.class)
	public void testWriteArticle_NullPointerException(){
		boardService.writeArticle(null);
	}
	
	@Test
	public void testUpdateArticle() {
		ArticleVO articleVO = new ArticleVO();
		articleVO.setId(testWritedArticleId_forUpdate);
		articleVO.setSubject("업데이트한 게시글 입니다.");
		articleVO.setContent("업데이트한 내용입니다.");
		boardService.updateArticle(articleVO);
		ArticleVO article = boardService.readArticleById(testWritedArticleId_forUpdate);
		Assert.notNull(article);
		Assert.isTrue(article.getSubject().equals(articleVO.getSubject()));
		Assert.isTrue(article.getContent().equals(articleVO.getContent()));
	}
	
	@Test
	public void testDeleteArticleById(){
		boardService.deleteArticleById(testWritedArticleId_forUpdate);
		ArticleVO article = boardService.readArticleById(testWritedArticleId);
		Assert.isNull(article);
	}
}
