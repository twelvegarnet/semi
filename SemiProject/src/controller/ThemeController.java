package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.SeoulGrade;
import service.face.RestaurantService;
import service.impl.RestaurantServiceImpl;

/**
 * Servlet implementation class ThemeController
 */
@WebServlet("/main/theme")
public class ThemeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private RestaurantService restaurantService = new RestaurantServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/main/theme [GET]");
		System.out.println(req.getParameter("theme"));
		List<SeoulGrade> list = restaurantService.getThemeList(req.getParameter("theme"));
		
		for(SeoulGrade c : list) {
			System.out.println(c);
		}
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/main/theme.jsp").forward(req, resp);
	
	
	}
}
