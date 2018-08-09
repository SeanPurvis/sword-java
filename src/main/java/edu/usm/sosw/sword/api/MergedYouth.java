package edu.usm.sosw.sword.api;

public class MergedYouth {
	private int id;
	private String edited_table;
	private int table_id;
	private int old_youthid;
	private int new_youthid;
	
	public MergedYouth() {
		//Needed for Jackson deserialization
	}
	
	public MergedYouth(
			int id,
			String edited_table,
			int table_id,
			int old_youthid,
			int new_youthid) {
		this.id = id;
		this.edited_table = edited_table;
		this.table_id = table_id;
		this.old_youthid = old_youthid;
		this.new_youthid = new_youthid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEdited_table() {
		return edited_table;
	}

	public void setEdited_table(String edited_table) {
		this.edited_table = edited_table;
	}

	public int getTable_id() {
		return table_id;
	}

	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}

	public int getOld_youthid() {
		return old_youthid;
	}

	public void setOld_youthid(int old_youthid) {
		this.old_youthid = old_youthid;
	}

	public int getNew_youthid() {
		return new_youthid;
	}

	public void setNew_youthid(int new_youthid) {
		this.new_youthid = new_youthid;
	}
	
	
}
