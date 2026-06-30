package model;

public class Doctor {
	private String qualification;
	
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void Assist() {
		System.out.println(" Doctor is assessing ");
	}

}
