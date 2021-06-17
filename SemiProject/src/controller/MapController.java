package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.SeoulGrade;
import review.dto.Seoul;
import service.face.RestaurantService;
import service.impl.RestaurantServiceImpl;

/**
 * Servlet implementation class MapController
 */
@WebServlet("/main/map")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RestaurantService restaurantService = new RestaurantServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("main/map [GET]");
		
		
		List<Seoul> list = restaurantService.getTopRest();
		
		// [TEST]
//		for(Seoul c : list) {
//			System.out.println(c);
//		}
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/main/map.jsp").forward(req, resp);
		
		
	
	}
}
