package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import dto.Recipe;
import service.face.RecipeService;
import service.impl.RecipeServiceImpl;

@WebServlet("/mypage/recipelist")
public class MyPageRecipeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//해당 회원이 작성한 레시피 리스트 불러오기
		Object userno1 = req.getSession().getAttribute("userno");
		int userno = (int) userno1;
		
		Paging paging = recipeService.getPaging(req, userno);

		req.setAttribute("paging", paging);
		
		//전체 레시피 리스트
		List<Recipe> list = recipeService.getRecipe(userno);
		
		req.setAttribute("list", list);
		
		//해당 회원이 작성한 레시피 리스트
		List<Recipe> rList = recipeService.getRecipe(paging, userno);
		
		req.setAttribute("rList", rList);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/mypage_recipelist.jsp")
			.forward(req, resp);
		
	}
}