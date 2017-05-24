package ezc.user.dao;

import java.util.List;

import ezc.model.Retailer;


public interface RetailerDAO {
public List<Retailer> getRetailers();
public Retailer addRetailer(Retailer ret);
public Retailer updateRetailer();
public Retailer deleteRetailer();
}
