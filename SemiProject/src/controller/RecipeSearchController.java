package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import dto.Member;
import dto.Recipe;
import service.face.MemberService;
import service.face.RecipeService;
import service.impl.MemberServiceImpl;
import service.impl.RecipeServiceImpl;

@WebServlet("/recipe/search")
public class RecipeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터를 전달하여 Paging객체 생성하기
		Paging paging = recipeService.getPaging(req);
		
		//해당 검색어를 제목 혹은 본문에 포함하는지 체크
		List<Recipe> list = recipeService.getRecipeList(req, paging);
		
		req.setAttribute("paging", paging);
		
		req.setAttribute("List", list);
		
		//모든 회원정보를 받을 리스트 객체 생성
		List<Member> mList = new ArrayList<>();
		
		//모든 회원정보를 호출하기
		mList = memberService.getUserdata();
		
		//세션에 속성값으로 mList 설정
		req.setAttribute("mList", mList);
		
		req.getRequestDispatcher("/WEB-INF/views/board/recipe/recipeSearch.jsp")
			.forward(req, resp);
		
	}
}
