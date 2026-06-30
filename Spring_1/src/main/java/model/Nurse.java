package model;

public class Nurse {
	private String qualification;
	
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void Assist()
	{
		System.out.println("Nurse is assessing");
	}

}
