package com.onetrillion.trip.admin;

public class AdminDTO {

	private String AD_ID;
	private String AD_PWD;
	private String AD_NAME;
	private String AD_TEL;

	public String getAD_ID() {
		return AD_ID;
	}

	public void setAD_ID(String aD_ID) {
		AD_ID = aD_ID;
	}

	public String getAD_PWD() {
		return AD_PWD;
	}

	public void setAD_PWD(String aD_PWD) {
		AD_PWD = aD_PWD;
	}

	public String getAD_NAME() {
		return AD_NAME;
	}

	public void setAD_NAME(String aD_NAME) {
		AD_NAME = aD_NAME;
	}

	public String getAD_TEL() {
		return AD_TEL;
	}

	public void setAD_TEL(String aD_TEL) {
		AD_TEL = aD_TEL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AD_ID == null) ? 0 : AD_ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminDTO other = (AdminDTO) obj;
		if (AD_ID == null) {
			if (other.AD_ID != null)
				return false;
		} else if (!AD_ID.equals(other.AD_ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminDTO [AD_ID=" + AD_ID + ", AD_PWD=" + AD_PWD + ", AD_NAME=" + AD_NAME + ", AD_TEL=" + AD_TEL + "]";
	}

}
