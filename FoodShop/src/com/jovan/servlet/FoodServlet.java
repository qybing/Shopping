package com.jovan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jovan.biz.impl.FoodBizImpl;
import com.jovan.entity.Food;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			
			int nowPage = 1;
			if(request.getParameter("page") != null){
				nowPage = Integer.parseInt(request.getParameter("page"));
			}
			String min_price = request.getParameter("min_price");
			String max_price =  request.getParameter("max_price");
			String food_name = request.getParameter("food_name");

			Food food = new Food();
			if( min_price != null && !min_price.equals("")){
				food.setMin_price(Integer.parseInt(min_price));
			}
			if( max_price != null && !max_price.equals("")){
				food.setMax_price(Integer.parseInt(max_price));
			}
			if( food_name != null && !food_name.equals("")){
				food.setFood_name(food_name);
			}
			FoodBizImpl foodBizImpl =  new FoodBizImpl();
			/* List<Food> foodList = foodBizImpl.findAllFoods(); */
			int pages_sum = foodBizImpl.findFoodsPages(food);
			/* System.out.print(pages_sum); */ 
			if(nowPage<1||nowPage>pages_sum){
				nowPage = 1;
			}
			
			List<Food> foodList = foodBizImpl.findFoods(nowPage,food);
			session.setAttribute("nowPage", nowPage);
			session.setAttribute("foodList", foodList);
			session.setAttribute("food", food);
			session.setAttribute("pages_sum", pages_sum);
			request.getRequestDispatcher("food.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
