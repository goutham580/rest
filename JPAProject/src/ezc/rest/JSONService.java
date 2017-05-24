package ezc.rest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ezc.model.Distrubutor;
import ezc.user.dao.DistrubutorDAO;
import ezc.user.dao.DistrubutorDAOImpl;


@Path("/admin/distrubutor")
public class JSONService {

		
	@GET
	@Path("/list_B")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Distrubutor> getDistrubutors() {
		List<Distrubutor> resultList = null;
        DistrubutorDAO dao= new DistrubutorDAOImpl();
        resultList = dao.getDistrubutors();
        HashMap<String, List<Distrubutor>> hm = new HashMap<String, List<Distrubutor>>();
        hm.put("test", resultList);
		return resultList;

	}
	
	@GET
	@Path("/map")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, List<Distrubutor>> getDistrubutorsMap() {
        List<Distrubutor> resultList = null;
        DistrubutorDAO dao= new DistrubutorDAOImpl();
        resultList = dao.getDistrubutors();
        HashMap<String, List<Distrubutor>> hm = new HashMap<String, List<Distrubutor>>();
        hm.put("test", resultList);
		return hm;
	}

	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Distrubutor createDistrubutorInJSON(Distrubutor distrubutor) {

		DistrubutorDAO dao= new DistrubutorDAOImpl();
		distrubutor = dao.addDistrubutor(distrubutor);
		//String result = "Distrubutor saved : " + distrubutor.getDistrubutorId();
		//Response.status(201).entity(result).build()
		return distrubutor;

	}

}