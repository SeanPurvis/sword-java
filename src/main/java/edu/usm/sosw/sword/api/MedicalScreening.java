package edu.usm.sosw.sword.api;

import java.sql.Date;

public class MedicalScreening {
	private int id;
	private int youthid;
	private Date screening_date;
	private String personal_physician_test;
	private String personal_physician_text;
	private String possession_medication_text;
	private String is_fever;
	private String is_chest_pain;
	private String is_cough;
	private String is_abdominal_pain;
	private String is_weight_loss;
	private String is_bleeding;
	private String is_night_sweats;
	private String is_change_urination;
	private String is_change_bowel_movement;
	private String is_bleeding_from_either_site;
	private String is_diabetes;
	private String is_asthma;
	private String is_heart_disease;
	private String is_ulcers;
	private String is_seizure;
	private String is_high_blood_pressure;
	private String is_arthritis;
	private String is_psychiatric_disorder;
	private String is_epilepsy;
	private String is_tuberculosis;
	private String is_hepatitis;
	private String skin_rash;
	private String allergic;
	private String hiv;
	private String other_medical_problems;
	private String operation_hist;
	private String chronic_illness;
	private String medical_restrictions;
	private String hasinsurance;
	private String sign_withdrawal;
	private String risk_suicide;
	private String admitted_psychiatric;
    private String taken_antidepressant;
    private String is_hospitalized;
    private String is_seen_medical_doctor;
    private String is_seen_psychiatric_doctor;
    private String blood_pressure;
    private String temperature;
    private String pulse;
    private String resp;
    private String notes;
    
    public MedicalScreening() {
    	//Needed for Jackson deserialization
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYouthid() {
		return youthid;
	}

	public void setYouthid(int youthid) {
		this.youthid = youthid;
	}

	public Date getScreening_date() {
		return screening_date;
	}

	public void setScreening_date(Date screening_date) {
		this.screening_date = screening_date;
	}

	public String getPersonal_physician_test() {
		return personal_physician_test;
	}

	public void setPersonal_physician_test(String personal_physician_test) {
		this.personal_physician_test = personal_physician_test;
	}

	public String getPersonal_physician_text() {
		return personal_physician_text;
	}

	public void setPersonal_physician_text(String personal_physician_text) {
		this.personal_physician_text = personal_physician_text;
	}

	public String getPossession_medication_text() {
		return possession_medication_text;
	}

	public void setPossession_medication_text(String possession_medication_text) {
		this.possession_medication_text = possession_medication_text;
	}

	public String getIs_fever() {
		return is_fever;
	}

	public void setIs_fever(String is_fever) {
		this.is_fever = is_fever;
	}

	public String getIs_chest_pain() {
		return is_chest_pain;
	}

	public void setIs_chest_pain(String is_chest_pain) {
		this.is_chest_pain = is_chest_pain;
	}

	public String getIs_cough() {
		return is_cough;
	}

	public void setIs_cough(String is_cough) {
		this.is_cough = is_cough;
	}

	public String getIs_abdominal_pain() {
		return is_abdominal_pain;
	}

	public void setIs_abdominal_pain(String is_abdominal_pain) {
		this.is_abdominal_pain = is_abdominal_pain;
	}

	public String getIs_weight_loss() {
		return is_weight_loss;
	}

	public void setIs_weight_loss(String is_weight_loss) {
		this.is_weight_loss = is_weight_loss;
	}

	public String getIs_bleeding() {
		return is_bleeding;
	}

	public void setIs_bleeding(String is_bleeding) {
		this.is_bleeding = is_bleeding;
	}

	public String getIs_night_sweats() {
		return is_night_sweats;
	}

	public void setIs_night_sweats(String is_night_sweats) {
		this.is_night_sweats = is_night_sweats;
	}

	public String getIs_change_urination() {
		return is_change_urination;
	}

	public void setIs_change_urination(String is_change_urination) {
		this.is_change_urination = is_change_urination;
	}

	public String getIs_change_bowel_movement() {
		return is_change_bowel_movement;
	}

	public void setIs_change_bowel_movement(String is_change_bowel_movement) {
		this.is_change_bowel_movement = is_change_bowel_movement;
	}

	public String getIs_bleeding_from_either_site() {
		return is_bleeding_from_either_site;
	}

	public void setIs_bleeding_from_either_site(String is_bleeding_from_either_site) {
		this.is_bleeding_from_either_site = is_bleeding_from_either_site;
	}

	public String getIs_diabetes() {
		return is_diabetes;
	}

	public void setIs_diabetes(String is_diabetes) {
		this.is_diabetes = is_diabetes;
	}

	public String getIs_asthma() {
		return is_asthma;
	}

	public void setIs_asthma(String is_asthma) {
		this.is_asthma = is_asthma;
	}

	public String getIs_heart_disease() {
		return is_heart_disease;
	}

	public void setIs_heart_disease(String is_heart_disease) {
		this.is_heart_disease = is_heart_disease;
	}

	public String getIs_ulcers() {
		return is_ulcers;
	}

	public void setIs_ulcers(String is_ulcers) {
		this.is_ulcers = is_ulcers;
	}

	public String getIs_seizure() {
		return is_seizure;
	}

	public void setIs_seizure(String is_seizure) {
		this.is_seizure = is_seizure;
	}

	public String getIs_high_blood_pressure() {
		return is_high_blood_pressure;
	}

	public void setIs_high_blood_pressure(String is_high_blood_pressure) {
		this.is_high_blood_pressure = is_high_blood_pressure;
	}

	public String getIs_arthritis() {
		return is_arthritis;
	}

	public void setIs_arthritis(String is_arthritis) {
		this.is_arthritis = is_arthritis;
	}

	public String getIs_psychiatric_disorder() {
		return is_psychiatric_disorder;
	}

	public void setIs_psychiatric_disorder(String is_psychiatric_disorder) {
		this.is_psychiatric_disorder = is_psychiatric_disorder;
	}

	public String getIs_epilepsy() {
		return is_epilepsy;
	}

	public void setIs_epilepsy(String is_epilepsy) {
		this.is_epilepsy = is_epilepsy;
	}

	public String getIs_tuberculosis() {
		return is_tuberculosis;
	}

	public void setIs_tuberculosis(String is_tuberculosis) {
		this.is_tuberculosis = is_tuberculosis;
	}

	public String getIs_hepatitis() {
		return is_hepatitis;
	}

	public void setIs_hepatitis(String is_hepatitis) {
		this.is_hepatitis = is_hepatitis;
	}

	public String getSkin_rash() {
		return skin_rash;
	}

	public void setSkin_rash(String skin_rash) {
		this.skin_rash = skin_rash;
	}

	public String getAllergic() {
		return allergic;
	}

	public void setAllergic(String allergic) {
		this.allergic = allergic;
	}

	public String getHiv() {
		return hiv;
	}

	public void setHiv(String hiv) {
		this.hiv = hiv;
	}

	public String getOther_medical_problems() {
		return other_medical_problems;
	}

	public void setOther_medical_problems(String other_medical_problems) {
		this.other_medical_problems = other_medical_problems;
	}

	public String getOperation_hist() {
		return operation_hist;
	}

	public void setOperation_hist(String operation_hist) {
		this.operation_hist = operation_hist;
	}

	public String getChronic_illness() {
		return chronic_illness;
	}

	public void setChronic_illness(String chronic_illness) {
		this.chronic_illness = chronic_illness;
	}

	public String getMedical_restrictions() {
		return medical_restrictions;
	}

	public void setMedical_restrictions(String medical_restrictions) {
		this.medical_restrictions = medical_restrictions;
	}

	public String getHasinsurance() {
		return hasinsurance;
	}

	public void setHasinsurance(String hasinsurance) {
		this.hasinsurance = hasinsurance;
	}

	public String getSign_withdrawal() {
		return sign_withdrawal;
	}

	public void setSign_withdrawal(String sign_withdrawal) {
		this.sign_withdrawal = sign_withdrawal;
	}

	public String getRisk_suicide() {
		return risk_suicide;
	}

	public void setRisk_suicide(String risk_suicide) {
		this.risk_suicide = risk_suicide;
	}

	public String getAdmitted_psychiatric() {
		return admitted_psychiatric;
	}

	public void setAdmitted_psychiatric(String admitted_psychiatric) {
		this.admitted_psychiatric = admitted_psychiatric;
	}

	public String getTaken_antidepressant() {
		return taken_antidepressant;
	}

	public void setTaken_antidepressant(String taken_antidepressant) {
		this.taken_antidepressant = taken_antidepressant;
	}

	public String getIs_hospitalized() {
		return is_hospitalized;
	}

	public void setIs_hospitalized(String is_hospitalized) {
		this.is_hospitalized = is_hospitalized;
	}

	public String getIs_seen_medical_doctor() {
		return is_seen_medical_doctor;
	}

	public void setIs_seen_medical_doctor(String is_seen_medical_doctor) {
		this.is_seen_medical_doctor = is_seen_medical_doctor;
	}

	public String getIs_seen_psychiatric_doctor() {
		return is_seen_psychiatric_doctor;
	}

	public void setIs_seen_psychiatric_doctor(String is_seen_psychiatric_doctor) {
		this.is_seen_psychiatric_doctor = is_seen_psychiatric_doctor;
	}

	public String getBlood_pressure() {
		return blood_pressure;
	}

	public void setBlood_pressure(String blood_pressure) {
		this.blood_pressure = blood_pressure;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
    
    
	
}