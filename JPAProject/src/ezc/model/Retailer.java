package ezc.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the retailer database table.
 * 
 */
@Entity
@XmlRootElement(name="Retailer")
@NamedQuery(name="Retailer.findAll", query="SELECT r FROM Retailer r")
public class Retailer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "RetailerGenerator", table = "NUMBER_RANGES", pkColumnName = "GENERATOR_NAME", valueColumnName = "GENERATOR_VALUE", pkColumnValue = "Retailer", initialValue = 200000, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "RetailerGenerator")
	private int retailerId;

	private String city;

	private int mobile;

	private String name;

	private int phone;

	private String state;

	private String street;

	private String zip;

	//bi-directional many-to-one association to Distrubutor
	@ManyToOne
	@JoinColumn(name="DistrubutorId")
	private Distrubutor distrubutor;

	public Retailer() {
	}

	public int getRetailerId() {
		return this.retailerId;
	}

	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
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

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Distrubutor getDistrubutor() {
		return this.distrubutor;
	}

	public void setDistrubutor(Distrubutor distrubutor) {
		this.distrubutor = distrubutor;
	}

}