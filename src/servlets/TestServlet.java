package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.MitarbeiterInterface;
import model.Mitarbeiter;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "java:global/SwArchWebApplication/MitarbeiterBean!beans.MitarbeiterInterface") 
	private MitarbeiterInterface bean;
	
	public TestServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		List<Mitarbeiter> ml = bean.getMitarbeiterList();
		
		out.write("<html>");
		out.write("<h1>");
		
		out.write("Hallo Albstadt! <br />");
		for(Mitarbeiter m: ml){
			out.write(m.getId()+" "+m.getVorname()+" "+m.getNachname()+"<br>");
		}
		
		out.write("</h1");
		out.write("</html>");
	}
}
