package ec.ups.edu.controlador;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDAO;
import ec.edu.ups.dao.TargetaDAO;
import ec.edu.ups.entidades.Comida;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Targeta;

/**
 * Servlet implementation class GenerarPedido
 */
@WebServlet("/GenerarPedido")
public class GenerarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Pedido p;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarPedido() {
        super();
        p=new Pedido();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String cliente=request.getParameter("cliente");
		String nombre=request.getParameter("nombre");
		String precio=request.getParameter("precio");
		String opcion=request.getParameter("opcion");
		String numTarjeta=request.getParameter("numTargeta");
		
		if(opcion.equals("fin")) {
			PedidoDAO pedidoDAO=DAOFactory.getFactory().getPedidoDAO();
			TargetaDAO targetaDAO=DAOFactory.getFactory().getTargetaDAO();
			Targeta targeta=targetaDAO.findByNumero(Integer.parseInt(numTarjeta));
			p.setTargeta(targeta);
			p.setFecha(new GregorianCalendar());
			pedidoDAO.create(p);
			
			getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
		}else {
			p.setCliente(cliente);			
			p.addComida(new Comida(nombre,Double.parseDouble(precio),p));
			p.calcularComidas();
			
			request.setAttribute("pedido", p);
			String url = "/generarPedido.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
