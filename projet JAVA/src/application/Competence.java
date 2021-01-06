package application;

public class Competence{
    private final Referentiel referentiel; // Composition 

	private int id_cmptnce;
	private String cmptnce;
	private boolean N1;
	private boolean N2;
	private boolean N3;
	
	public Competence(Referentiel referentiel, int id_cmptnce, String cmptnce, boolean n1, boolean n2, boolean n3) {
		super();
		this.referentiel = referentiel;
		this.id_cmptnce = id_cmptnce;
		this.cmptnce = cmptnce;
		N1 = n1;
		N2 = n2;
		N3 = n3;
	}
	
	
	

	
	
	
	

	
	

}
