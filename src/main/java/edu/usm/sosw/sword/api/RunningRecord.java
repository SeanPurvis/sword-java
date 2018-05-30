package edu.usm.sosw.sword.api;

public class RunningRecord {
	private String did;
	private int youthid;
	private int id;
	private int noteid;
	private int notepartid;
	private String note;
	
	public RunningRecord() {
		//Needed for Jackson deserialization
	}

	public RunningRecord(String did, int youthid, int id, int noteid, int notepartid, String note) {
		this.did = did;
		this.youthid = youthid;
		this.id = id;
		this.noteid = noteid;
		this.notepartid = notepartid;
		this.note = note;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public int getYouthid() {
		return youthid;
	}

	public void setYouthid(int youthid) {
		this.youthid = youthid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoteid() {
		return noteid;
	}

	public void setNoteid(int noteid) {
		this.noteid = noteid;
	}

	public int getNotepartid() {
		return notepartid;
	}

	public void setNotepartid(int notepartid) {
		this.notepartid = notepartid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
