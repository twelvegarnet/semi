package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Notice;
import service.face.NoticeService;
import service.face.RecipeService;
import service.impl.RecipeServiceImpl;

@WebServlet("/mypage/recipedelete")
public class MyPageRecipeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		recipeService.deleteRecipe(req);
		
		resp.sendRedirect("/mypage/recipelist");
		
	}
}
