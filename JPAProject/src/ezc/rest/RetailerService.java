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
import ezc.model.Retailer;
import ezc.user.dao.RetailerDAO;
import ezc.user.dao.RetailerDAOImpl;


@Path("/admin/retailer")
public class RetailerService {

		
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Retailer> getRetailers() {
		List<Retailer> resultList = null;
        RetailerDAO dao= new RetailerDAOImpl();
        resultList = dao.getRetailers();
        HashMap<String, List<Retailer>> hm = new HashMap<String, List<Retailer>>();
        hm.put("retailer", resultList);
		return resultList;

	}
	
	@GET
	@Path("/map")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, List<Retailer>> getRetailersMap() {
        List<Retailer> resultList = null;
        RetailerDAO dao= new RetailerDAOImpl();
        resultList = dao.getRetailers();
        HashMap<String, List<Retailer>> hm = new HashMap<String, List<Retailer>>();
        hm.put("retailer", resultList);
		return hm;
	}

	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Retailer createRetailerInJSON(Retailer retailer) {

		RetailerDAO dao= new RetailerDAOImpl();
		retailer = dao.addRetailer(retailer);
		return retailer;

	}

}