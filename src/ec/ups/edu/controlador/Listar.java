package ec.ups.edu.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDAO;

import ec.edu.ups.entidades.Pedido;

/**
 * Servlet implementation class Listar
 */
@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Listar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String opcion = request.getParameter("opcion");
		String criterio = request.getParameter("criterio");
		PedidoDAO pedidoDAO = DAOFactory.getFactory().getPedidoDAO();
		
		List<Pedido> pedidos = null;
		if (opcion.equals("comida")) {
			pedidos = pedidoDAO.findByComida(criterio);
			
		} else if (opcion.equals("numTargeta")) {
			pedidos = pedidoDAO.findByNumTar(criterio);
			
		}
		request.setAttribute("pedidos", pedidos);
		getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
