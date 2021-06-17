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
 * Servlet implementation class FoodListController
 */
@WebServlet("/main/foodlist")
public class FoodListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RestaurantService restaurantService = new RestaurantServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/main/foodlist [GET]");
		
		System.out.println(req.getParameter("food"));
	
		SeoulGrade restaurant = restaurantService.setQueryString(req);
		
		System.out.println(restaurant);
		
		
		List<SeoulGrade> list = restaurantService.getFoodList(restaurant);
		
		// [TEST]
//		for(SeoulGrade c : list) {
//			System.out.println(c);
//		}
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/main/foodMenu.jsp").forward(req, resp);
		
		
		
	}
}
