package com.adobe.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // MIME type
		PrintWriter out = response.getWriter(); // opens character stream to browser
		out.print("<html><body>");
		out.print("<table border=\"1\">");
		out.print("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
		ProductDao productDao = new ProductDaoJdbcImpl(); // better use Factory
		try {
			List<Product> products = productDao.getProducts();
			for (Product p : products) {
				out.print("<tr>");
				out.print("<td>" + p.getId() + "</td>");
				out.print("<td>" + p.getName() + "</td>");
				out.print("<td>" + p.getPrice() + "</td>");
				out.print("</tr>");
			}
		} catch (DaoException e) {
			out.println(e.getMessage());
		}

		out.print("</table>");
		out.print("<a href=\"index.html\">Back</a>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		ProductDao productDao = new ProductDaoJdbcImpl();

		try {
			Product p = new Product(0, name, price, 100);
			productDao.addProduct(p);
			response.sendRedirect("index.html");
		} catch (DaoException e) {
			e.printStackTrace(); // development state
//			System.out.println(e.getMessage());
		}
	}

}
