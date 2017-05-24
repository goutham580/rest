package ezc.user.dao;
import java.util.List;
import javax.persistence.EntityManager;
import ezc.db.util.EzcEntityFactory;
import ezc.model.Distrubutor;

public class DistrubutorDAOImpl implements DistrubutorDAO {

	@Override
	public List<Distrubutor> getDistrubutors() {
		// TODO Auto-generated method stub
		List<Distrubutor> resultList = null;
        try {
			EntityManager em = EzcEntityFactory.createEntityManager();
			resultList = em.createNamedQuery("Distrubutor.findAll").getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Distrubutor addDistrubutor(Distrubutor dist) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = EzcEntityFactory.createEntityManager();
			em.getTransaction().begin();
            em.persist(dist);
            em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dist;
	}

	@Override
	public Distrubutor updateDistrubutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Distrubutor deleteDistrubutor() {
		// TODO Auto-generated method stub
		return null;
	}

}
