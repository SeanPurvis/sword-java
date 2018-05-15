package edu.usm.sosw.sword.api;

/**
 * This class is a representation rows of the <code>static_counties</code> table in Plain Old Java Object form.
 * With the exception of the empty default constructor, every function is auto generated from the expressed
 * private methods. An object of this class can be consumed and produced by the <code>CountyResource</code> end point.
 * @author Sean T. Purvis
 * @version 0.0.1
 * @see CountyMapper
 * @see CountyDAO
 * @see CountyResource
 */
public class County {
	private int id;
	private String name;
	
	public County() {
		//Needed for Jackson deserialization
	}
	
	public County(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
