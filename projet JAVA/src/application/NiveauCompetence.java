package application;

public class NiveauCompetence implements Interface_User_Competence {

	private boolean N1;
	private boolean N2;
	private boolean N3;

	public NiveauCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NiveauCompetence(boolean n1, boolean n2, boolean n3) {
		super();
		N1 = n1;
		N2 = n2;
		N3 = n3;
	}

	public boolean isN1() {
		return N1;
	}

	public void setN1(boolean n1) {
		N1 = n1;
	}

	public boolean isN2() {
		return N2;
	}

	public void setN2(boolean n2) {
		N2 = n2;
	}

	public boolean isN3() {
		return N3;
	}

	public void setN3(boolean n3) {
		N3 = n3;
	}

}