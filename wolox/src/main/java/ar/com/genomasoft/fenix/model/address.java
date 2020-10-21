package ar.com.genomasoft.fenix.model;

public class address {

	String street;
	String suite;
	String city;
	String zipcode;
    geo geo;
    
    public address() {
	}
    
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public geo getGeo() {
		return geo;
	}
	public void setGeo(geo geo) {
		this.geo = geo;
	}
    
    
}
