

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.Model.Carros;
import br.Model.CarrosDao;




@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarrosDao cont;

       
    public Controller() {
    	super();
        this.cont = new CarrosDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		if (option == null) {
			option = "qualquer coisa";
		}
		switch(option) {
			case ("insertForm"):
				showInsertCarros(request, response);
			break;
			case ("updateForm"):
				showUpdateCarros(request, response);
			break;
			case ("update"):
				updateCarros(request, response);
			break;
			case ("delete"):
				deleteCarros(request, response);
			break;
			case ("insert"):
				insert(request, response);
			break;
			default:
				selectAll(request, response);
		}
	}
	
	private void showInsertCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void showUpdateCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
	    Carros ca = this.cont.selectById(id);
		request.setAttribute("carros", ca);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void insert(HttpServletRequest tomate, HttpServletResponse alface) throws ServletException, IOException{
		String anoBack = tomate.getParameter("ano");
		String modeloBack = tomate.getParameter("modelo");
		if ((anoBack != null) && (modeloBack != null))  {
			if (!anoBack.equals("")){
				Carros carros = new Carros(anoBack, modeloBack);
				this.cont.insert(carros);
			}
		}
		alface.sendRedirect("Controller");
	}
	
	private void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listUser", this.cont.selectAll());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void deleteCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("id");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.cont.removeCarros(id);
		}
		response.sendRedirect("Controller");
	}
	
	private void updateCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anoBack = request.getParameter("ano");
		String modeloBack = request.getParameter("modelo");
		String idBack = request.getParameter("id");
		if ((anoBack != null) && (modeloBack != null)  && (idBack != null)) {
			if (!anoBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				Carros carro1 = new Carros(anoBack, modeloBack);
				carro1.setId(id);
				this.cont.updateCarros(carro1);
			}
		}
		response.sendRedirect("Controller");
	}
	
}
