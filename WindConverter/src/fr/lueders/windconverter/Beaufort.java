package fr.lueders.windconverter;

public class Beaufort {
	
	public int n; 
	public String descr;
	public String wirkungAufSee;
	public String wirkungAufLand;
	
	public Beaufort(int n, String descr, String wirkungAufSee, String wirkungAufLand) {
		this.n = n;
		this.descr = descr;
		this.wirkungAufSee = wirkungAufSee;
		this.wirkungAufLand= wirkungAufLand;
	}

}
