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

@WebServlet("/mypage/recipeupdate")
public class MyPageRecipeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();
	private FileService fileService = new FileServiceImpl();
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//글번호에 해당하는 모든 정보 가져오기
		Recipe recipe = new Recipe();
				
		//게시글의 회원번호 가져오기(확인 완료)
		String postno1 = req.getParameter("postno");
		int postno = Integer.parseInt(postno1);
				
		//게시글의 회원번호로 해당 게시글의 모든 데이터 가져오기
		recipe = recipeService.getDataByUserno(postno1);
				
		//얻어온 레시피 게시글 정보 속성 정의
		req.setAttribute("recipe", recipe);
		
		System.out.println("recipe 확인 : " + recipe);
		
		//첨부파일 정보 불러오기
		List<UploadFile> list = fileService.getFileData(postno);
								
		//첨부파일 객체 속성값으로 설정
		req.setAttribute("fileList", list);
		
		System.out.println("fileList 확인 : " + list);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/mypage_recipeupdate.jsp")
			.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//받는 값을 utf-8로 인코딩
		req.setCharacterEncoding("UTF-8");
				
		//req를 service로 넘기고 conn을 추가해서 dao로 넘겨서 update 진행
		recipeService.Updatedata(req);
				
		//detail.jps로 보낼 recipe 객체 생성
		Recipe recipe = new Recipe();
				
		//req객체에서 recipe 데이터만 뽑아서 recipe객체에 저장
		recipe = recipeService.getRecipeDataFromReq(req);

		//detail.jsp로 보낼 recipe 속성 set
		req.setAttribute("Recipe", recipe);

		//모든 회원정보를 받을 리스트 객체 생성
		List<Member> mList = new ArrayList<>();
				
		//모든 회원정보를 호출하기
		mList = memberService.getUserdata();

		//세션에 속성값으로 mList 설정
		req.setAttribute("mList", mList);
				
		recipeService.Update(req, resp);

		resp.sendRedirect("/mypage/recipelist");
		
	}
}
