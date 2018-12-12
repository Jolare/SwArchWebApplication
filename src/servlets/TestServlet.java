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

import beans.GebaudeInterface;
import beans.KoordinateInterface;
import beans.MaschineInterface;
import beans.MitarbeiterInterface;
import beans.ProduktionInterface;
import beans.RaumInterface;
import beans.StandortInterface;
import model.Gebaude;
import model.Koordinate;
import model.Maschine;
import model.Mitarbeiter;
import model.Produktion;
import model.Raum;
import model.Standort;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "java:global/SwArchWebApplication/MitarbeiterBean!beans.MitarbeiterInterface") 
	private MitarbeiterInterface mitarbeiterBean;

	@EJB(mappedName = "java:global/SwArchWebApplication/StandortBean!beans.StandortInterface") 
	private StandortInterface standortBean;
	
	@EJB(mappedName = "java:global/SwArchWebApplication/GebaudeBean!beans.GebaudeInterface") 
	private GebaudeInterface gebaudeBean;
	
	@EJB(mappedName = "java:global/SwArchWebApplication/RaumBean!beans.RaumInterface") 
	private RaumInterface raumBean;
	
	@EJB(mappedName = "java:global/SwArchWebApplication/MaschineBean!beans.MaschineInterface") 
	private MaschineInterface maschineBean;
	
	@EJB(mappedName = "java:global/SwArchWebApplication/ProduktionBean!beans.ProduktionInterface") 
	private ProduktionInterface produktionBean;
	
	@EJB(mappedName = "java:global/SwArchWebApplication/KoordinateBean!beans.KoordinateInterface") 
	private KoordinateInterface koordinateBean;
	
	public TestServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		out.write("<html>");

		out.write("<h1>Test Mitarbeiter:</h1><div>");
		List<Mitarbeiter> ml = mitarbeiterBean.getMitarbeiterList();
		for(Mitarbeiter m: ml){
			out.write(m.getId()+" "+m.getVorname()+" "+m.getNachname()+"<br>");
		}
		out.write("</div>");
		
		out.write("<h1>Test Standort:</h1><div>");
		List<Standort> sl = standortBean.getStandortList();
		for(Standort s: sl){
			out.write(s.getId()+" "+s.getPlz()+" "+s.getOrt()+" "+s.getStrasse()+"<br>");
		}
		out.write("</div>");
		
		out.write("<h1>Test Gebaude:</h1><div>");
		List<Gebaude> gl = gebaudeBean.getGebaudeList();
		for(Gebaude g: gl){
			out.write(g.getId()+" "+g.getName()+" "+g.getStandort().getPlz()+" "+g.getStandort().getOrt()+" "+g.getStandort().getStrasse()+"<br>");
		}
		out.write("</div>");
		
		out.write("<h1>Test Raum:</h1><div>");
		List<Raum> rl = raumBean.getRaumList();
		for(Raum r: rl){
			out.write(r.getId()+" "+r.getGebaude().getName()+" "+"<br>");
		}
		out.write("</div>");
		
		out.write("<h1>Test Koordinate:</h1><div>");
		List<Koordinate> kl = koordinateBean.getKoordinateList();
		for(Koordinate k: kl){
			out.write(k.getId()+" "+k.getLaengengrad()+" "+k.getBreitengrad()+" "+" "+k.getRaum().getId()+"<br>");
		}
		out.write("</div>");
		
		out.write("<h1>Test Maschine:</h1><div>");
		List<Maschine> maschinel = maschineBean.getMaschineList();
		for(Maschine m: maschinel){
			out.write(m.getId()+" "+m.getRaum().getId()+" "+m.getRaum().getGebaude().getName()+" "+m.getMitarbeiter().getVorname()+" "+m.getMitarbeiter().getNachname()+"<br>");
		}
		out.write("</div>");
		
		out.write("<h1>Test Produktion:</h1><div>");
		List<Produktion> pl = produktionBean.getProduktionList();
		for(Produktion p: pl){
			out.write(p.getId()+" "+p.getDatum()+" "+p.getMaschine().getId()+" "+p.getNummer()+"<br>");
		}
		out.write("</div>");
		
		out.write("</html>");
	}
}
