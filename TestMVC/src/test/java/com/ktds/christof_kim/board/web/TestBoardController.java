package com.ktds.christof_kim.board.web;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.board.vo.ArticleVO;

//스프링이 제공하는 JUNIT클래스
//테스트 클래스가 실행될 때 제일 먼저 로딩된다.
@RunWith(SpringJUnit4ClassRunner.class)

//Dependency Injection이 필요한 경우 XML 설정 파일을 로딩한다.
//여러개의 설정파일을 로딩할 수 있
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/spring/dispatcherServlet.xml"})
public class TestBoardController {

	@Autowired
	private BoardController boardController;
	
	@Test
	public void testViewListPage() {
		System.out.println("testMethod입니다.");//출력 나오는지 테스트
		ModelAndView  view = boardController.viewListPage();
		Map<String, Object> model = view.getModel();		
		
		List<ArticleVO> list = (List<ArticleVO>)model.get("allArticleList");
		
		System.out.println(list.size());
		
		Assert.notEmpty(list);
		Assert.isTrue(list.size() >= 3);
		
		for(ArticleVO article : list) {
			//Assert.isTrue(article.getSubject().equals("Subject"));
		}
		//null은 메모리에 올린적도 없어
		//empty는 메모리를 올린적은 있는데 데이터 리턴이 없었다..
		//그런건 ctrl 플러스 갖다 대서 어떤걸 테스트 해야할지 알아야 함.
	}
	
	@Test
	public void testViewDetailPage() {
		ModelAndView view = boardController.viewDetailPage(4);
		Map<String, Object> model = view.getModel();
		ArticleVO article = (ArticleVO) model.get("article");
		
		Assert.notNull(article);
		Assert.isTrue(article.getSubject().equals("Subject"));
		Assert.isTrue(article.getContent().equals("Content"));
		
	}
	
	
}
