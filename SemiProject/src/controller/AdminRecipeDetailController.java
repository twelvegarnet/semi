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
import dto.UploadFile;
import service.face.FileService;
import service.face.MemberService;
import service.face.RecipeService;
import service.impl.FileServiceImpl;
import service.impl.MemberServiceImpl;
import service.impl.RecipeServiceImpl;

@WebServlet("/admin/recipedetail")
public class AdminRecipeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RecipeService recipeService = new RecipeServiceImpl();
	private MemberService memberService = new MemberServiceImpl();
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//받는 값을 utf-8로 인코딩
		req.setCharacterEncoding("UTF-8");

		//전달 파라미터 객체 생성
		String postno = req.getParameter("postno");
		
		//글번호에 해당하는 글 상세데이터 객체 생성
		Recipe recipe = recipeService.getRecipe(postno);
		
		//세션에 속성값으로 Recipe 설정
		req.setAttribute("Recipe", recipe);
		
		//모든 회원정보를 받을 리스트 객체 생성
		List<Member> mList = new ArrayList<>();
		
		//모든 회원정보를 호출하기
		mList = memberService.getUserdata();

		//세션에 속성값으로 mList 설정
		req.setAttribute("mList", mList);
		
		int postno1 = recipe.getPostno();
		
		//첨부파일 정보 불러오기
		List<UploadFile> list = fileService.getFileData(postno1);
		
		//첨부파일 객체 속성값으로 설정
		req.setAttribute("fileList", list);
		
		UploadFile uf = fileService.getStoredName(postno1);
		
		req.setAttribute("uploadfile", uf);
		
		//JSP로 연결
		req.getRequestDispatcher("/WEB-INF/views/admin/admin_recipedetail.jsp")
			.forward(req, resp);
	}
}