package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.MemberService;
import service.face.RecipeService;
import service.impl.MemberServiceImpl;
import service.impl.RecipeServiceImpl;

@WebServlet("/recipe/delete")
public class RecipeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	private RecipeService recipeService = new RecipeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 한 회원과 작성자가 일치하는지 확인
		if( (boolean) memberService.UsernoChk(req) ) {
			
			System.out.println("로그인 한 회원과 글작성자 일치");
			
			//삭제 method 호출
			recipeService.deleteRecipe(req);
			
		} else {
			
			System.out.println("로그인 한 회원과 글작성자 불일치");
			
		}
		
		resp.sendRedirect("/recipe/list");
		
	}
}