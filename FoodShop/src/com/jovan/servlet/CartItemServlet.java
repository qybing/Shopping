package com.jovan.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jovan.biz.impl.FoodBizImpl;
import com.jovan.entity.CartItem;
import com.jovan.entity.Food;

/**
 * Servlet implementation class CartItem
 */
@WebServlet("/CartItem")
public class CartItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemServlet() {
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
			//2-��ȡҳ��ֵ
			int food_id = Integer.parseInt(request.getParameter("food_id"));	
			int food_num =  1;
			//3-ҵ�񷽷�
			FoodBizImpl foodBizImpl = new FoodBizImpl();
			Food food = foodBizImpl.findFoodsById(food_id);
			Map<Integer,CartItem> carItemMap  = null;
			//4-1�жϹ��ﳵ�Ƿ���ڣ����û���򴴽�һ�����ﳵ
			if(session.getAttribute("carItemMap")==null){
				carItemMap = new HashMap<>();
			}else{
				carItemMap = (Map<Integer,CartItem>)session.getAttribute("carItemMap");
			}
			//���ﳵ���ڣ��ж��Ƿ��б���Ʒ���������ô������1
			//��������ڵģ���ô����һ����Ʒ����Ϣ��ӵ�Map��ȥ
			if(carItemMap.containsKey(food.getId())){
				CartItem carItem = carItemMap.get(food.getId());
				carItem.setCount(carItem.getCount()+1);
			}else{
				CartItem cartItem = new CartItem();
				cartItem.setFood(food);
				cartItem.setCount(1);
				carItemMap.put(food.getId(), cartItem);
			}
			// 3���湺�ﳵ
			session.setAttribute("carItemMap", carItemMap);
// ��תҳ��
response.sendRedirect("buyFood.jsp");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
