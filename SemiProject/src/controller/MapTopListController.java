package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.SeoulGrade;
import service.face.RestaurantService;
import service.impl.RestaurantServiceImpl;

/**
 * Servlet implementation class MapTopListController
 */
@WebServlet("/main/map/titlecheck")
public class MapTopListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestaurantService restaurantService = new RestaurantServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("/main/map/titlecheck [POST]");
		System.out.println(req.getParameter("title"));
		
		
		List<SeoulGrade> list = restaurantService.getTopRest(req);
		
		for(SeoulGrade c : list) {
			System.out.println(c);
		}
		
		req.setAttribute("list", list);

		
		req.getRequestDispatcher("/WEB-INF/views/main/ajax_map.jsp").forward(req, resp);
		
		
//		System.out.println(list.get(0).getCgg_code());
		
	}
}
