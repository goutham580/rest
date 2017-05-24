package ezc.user.dao;

import java.util.List;

import ezc.model.Distrubutor;


public interface DistrubutorDAO {
public List<Distrubutor> getDistrubutors();
public Distrubutor addDistrubutor(Distrubutor dist);
public Distrubutor updateDistrubutor();
public Distrubutor deleteDistrubutor();
}
