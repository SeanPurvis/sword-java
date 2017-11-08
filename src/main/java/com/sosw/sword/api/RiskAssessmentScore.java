package com.sosw.sword.api;

public class RiskAssessmentScore {
	private int id;
	private String assessment_type;
	private String classification;
	private int score;
	
	public RiskAssessmentScore() {
		//Needed for Jackson deserialization
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssessment_type() {
		return assessment_type;
	}

	public void setAssessment_type(String assessment_type) {
		this.assessment_type = assessment_type;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
