package ezc.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the distrubutor database table.
 * 
 */
@Entity
@XmlRootElement(name="Distrubutor")
@NamedQuery(name="Distrubutor.findAll", query="SELECT d FROM Distrubutor d")
public class Distrubutor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name = "DistrubutorGenerator", table = "NUMBER_RANGES", pkColumnName = "GENERATOR_NAME", valueColumnName = "GENERATOR_VALUE", pkColumnValue = "Distrubutor", initialValue = 100000, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "DistrubutorGenerator")
	private int distrubutorId;

	private String beat;

	private String city;

	private int mobile;

	private String name;

	private int phone;

	private String state;

	private String street;

	private int zip;

	//bi-directional many-to-one association to Retailer
	@OneToMany(mappedBy="distrubutor")
	private List<Retailer> retailers;

	public Distrubutor() {
	}

	public int getDistrubutorId() {
		return this.distrubutorId;
	}

	public void setDistrubutorId(int distrubutorId) {
		this.distrubutorId = distrubutorId;
	}

	public String getBeat() {
		return this.beat;
	}

	public void setBeat(String beat) {
		this.beat = beat;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMobile() {
		return this.mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public List<Retailer> getRetailers() {
		return this.retailers;
	}

	public void setRetailers(List<Retailer> retailers) {
		this.retailers = retailers;
	}

	public Retailer addRetailer(Retailer retailer) {
		getRetailers().add(retailer);
		retailer.setDistrubutor(this);

		return retailer;
	}

	public Retailer removeRetailer(Retailer retailer) {
		getRetailers().remove(retailer);
		retailer.setDistrubutor(null);

		return retailer;
	}

}