package edu.usm.sosw.sword.api;

import java.sql.Date;

public class PersonalProperty {
	private int caseid;
	private int id;
	private int locker_number;
	private String currency;
	private String belt;
	private String bra;
	private String dress;
	private String hat;
	private String jacket;
	private String leggings;
	private String pants;
	private String shirt;
	private String shoes;
	private String shorts;
	private String skirt;
	private String socks;
	private String underwear;
	private String bracelet;
	private String earrings;
	private String necklace;
	private String ring;
	private String watch;
	private String drugs;
	private String lighter;
	private String other_drugs;
	private String tobacco;
	private String weapons;
	private String other_property;
	private Date release_date;
	private String release_to;
	
	public PersonalProperty() {
		//Needed for Jackson deserialization
	}

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLocker_number() {
		return locker_number;
	}

	public void setLocker_number(int locker_number) {
		this.locker_number = locker_number;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBelt() {
		return belt;
	}

	public void setBelt(String belt) {
		this.belt = belt;
	}

	public String getBra() {
		return bra;
	}

	public void setBra(String bra) {
		this.bra = bra;
	}

	public String getDress() {
		return dress;
	}

	public void setDress(String dress) {
		this.dress = dress;
	}

	public String getHat() {
		return hat;
	}

	public void setHat(String hat) {
		this.hat = hat;
	}

	public String getJacket() {
		return jacket;
	}

	public void setJacket(String jacket) {
		this.jacket = jacket;
	}

	public String getLeggings() {
		return leggings;
	}

	public void setLeggings(String leggings) {
		this.leggings = leggings;
	}

	public String getPants() {
		return pants;
	}

	public void setPants(String pants) {
		this.pants = pants;
	}

	public String getShirt() {
		return shirt;
	}

	public void setShirt(String shirt) {
		this.shirt = shirt;
	}

	public String getShoes() {
		return shoes;
	}

	public void setShoes(String shoes) {
		this.shoes = shoes;
	}

	public String getShorts() {
		return shorts;
	}

	public void setShorts(String shorts) {
		this.shorts = shorts;
	}

	public String getSkirt() {
		return skirt;
	}

	public void setSkirt(String skirt) {
		this.skirt = skirt;
	}

	public String getSocks() {
		return socks;
	}

	public void setSocks(String socks) {
		this.socks = socks;
	}

	public String getUnderwear() {
		return underwear;
	}

	public void setUnderwear(String underwear) {
		this.underwear = underwear;
	}

	public String getBracelet() {
		return bracelet;
	}

	public void setBracelet(String bracelet) {
		this.bracelet = bracelet;
	}

	public String getEarrings() {
		return earrings;
	}

	public void setEarrings(String earrings) {
		this.earrings = earrings;
	}

	public String getNecklace() {
		return necklace;
	}

	public void setNecklace(String necklace) {
		this.necklace = necklace;
	}

	public String getRing() {
		return ring;
	}

	public void setRing(String ring) {
		this.ring = ring;
	}

	public String getWatch() {
		return watch;
	}

	public void setWatch(String watch) {
		this.watch = watch;
	}

	public String getDrugs() {
		return drugs;
	}

	public void setDrugs(String drugs) {
		this.drugs = drugs;
	}

	public String getLighter() {
		return lighter;
	}

	public void setLighter(String lighter) {
		this.lighter = lighter;
	}

	public String getOther_drugs() {
		return other_drugs;
	}

	public void setOther_drugs(String other_drugs) {
		this.other_drugs = other_drugs;
	}

	public String getTobacco() {
		return tobacco;
	}

	public void setTobacco(String tobacco) {
		this.tobacco = tobacco;
	}

	public String getWeapons() {
		return weapons;
	}

	public void setWeapons(String weapons) {
		this.weapons = weapons;
	}

	public String getOther_property() {
		return other_property;
	}

	public void setOther_property(String other_property) {
		this.other_property = other_property;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getRelease_to() {
		return release_to;
	}

	public void setRelease_to(String release_to) {
		this.release_to = release_to;
	}
	
	
}
