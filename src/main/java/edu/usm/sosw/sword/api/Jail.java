package edu.usm.sosw.sword.api;

public class Jail {
	private int id;
	private String name;
	private String unit;
	private String cells;
	
	public Jail() {
		//Needed for Jackson deserialization
	}
	
	public Jail(
			int id,
			String name,
			String unit,
			String cells) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.cells = cells;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCells() {
		return cells;
	}

	public void setCells(String cells) {
		this.cells = cells;
	}
	
}
