package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.FileService;
import service.face.RecipeService;
import service.impl.FileServiceImpl;
import service.impl.RecipeServiceImpl;

@WebServlet("/recipe/write")
public class RecipeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 되어있지 않으면 리다이렉트 
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/");
			
			return;
		}
		
		//JSP로 이동
		req.getRequestDispatcher("/WEB-INF/views/board/recipe/write.jsp")
			.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		//작성글 삽입 및 파일 업로드
		recipeService.write(req, resp);

		//목록으로 리다이렉트
		resp.sendRedirect("/recipe/list");
		
	}
	
}
