package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import dto.Recipe;
import common.Paging;
import service.face.MemberService;
import service.face.RecipeService;
import service.impl.MemberServiceImpl;
import service.impl.RecipeServiceImpl;

@WebServlet("/recipe/list")
public class RecipeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터를 전달하여 Paging객체 생성하기
		Paging paging = recipeService.getPaging(req);
		
		//모든 레시피를 담을 리스트 객체 생성
		List<Recipe> list = new ArrayList<>();
		
		//모든 리스트 불러내기
		list = recipeService.getRecipeList(paging);
		
		//세션에 속성값으로 paging 설정
		req.setAttribute("paging", paging);
		
		//세션에 속성값으로 list 설정
		req.setAttribute("List", list);
		
		//모든 회원정보를 받을 리스트 객체 생성
		List<Member> mList = new ArrayList<>();
		
		//모든 회원정보를 호출하기
		mList = memberService.getUserdata();
		
		//세션에 속성값으로 mList 설정
		req.setAttribute("mList", mList);
		
		
		//JSP (view)로 데이터 전달
		req.getRequestDispatcher("/WEB-INF/views/board/recipe/list.jsp")
			.forward(req, resp);
		
	}
	
}