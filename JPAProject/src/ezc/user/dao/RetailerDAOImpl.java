package ezc.user.dao;
import java.util.List;
import javax.persistence.EntityManager;
import ezc.db.util.EzcEntityFactory;
import ezc.model.Retailer;

public class RetailerDAOImpl implements RetailerDAO {

	@Override
	public List<Retailer> getRetailers() {
		// TODO Auto-generated method stub
		List<Retailer> resultList = null;
        try {
			EntityManager em = EzcEntityFactory.createEntityManager();
			resultList = em.createNamedQuery("Retailer.findAll").getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Retailer addRetailer(Retailer ret) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = EzcEntityFactory.createEntityManager();
			em.getTransaction().begin();
            em.persist(ret);
            em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Retailer updateRetailer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retailer deleteRetailer() {
		// TODO Auto-generated method stub
		return null;
	}

}
