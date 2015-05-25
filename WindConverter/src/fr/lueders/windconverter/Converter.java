package fr.lueders.windconverter;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Converter {
	
	private double conversionConst = 1.852;	
	
	private NavigableMap<Integer, Beaufort> map = new TreeMap<Integer, Beaufort>();

	public Converter() {
		map.put(0, new Beaufort(0, "Windstille", "glatte See", "Luft steht, nichts bewegt sich, Rauch steigt senkrecht nach oben"));
		map.put(1, new Beaufort(1, "leiser Zug", "kleine Kräuselwellen", "kaum spürbar, leichtes Säuseln der Blätter, Rauch wird etwas abgelenkt"));
		map.put(4, new Beaufort(2, "leichte Brise", "kurze, kleine Wellen",  "Blätter rascheln, Wind wird spürbar"));
		map.put(7, new Beaufort(3, "schwache Brise", "Wellenkämme beginnen zu brechen, einzelne Schaumkronen", "Blätter und dünne Zweige bewegen sich, Wimpel stellen sich auf, Fahnen flattern sichtbar"));
		map.put(11, new Beaufort(4, "mäßige Brise", "kleinere, längere Wellen mit Schaumkronen", "Zweige bewehen sich, loses Papier und Blätter werden vom Boden aufgehoben"));
		map.put(16, new Beaufort(5, "frische Brise", "lange, mässig hohe Wellen, überall Schaumkronen", "Größere Zweige bewegen sich, Bäume wiegen sich im Wind, deutlich hörbarer Wind"));
		map.put(22, new Beaufort(6, "starker Wind", "Größere Wellen, flächig Schaumkronen, Wellenkämme brechen, Gischt beginnt aufzukommen", " Dicke Äste, große Bäume bewegen sich, Wind beginnt z.B. an Drahtseilen zu pfeifen"));
		map.put(28, new Beaufort(7, "steifer Wind", "Wellen türmen sich auf, Schaum löst sich von den Wellenkämmen ab", " Bäume beginnen zusehends zu schwanken, beim Gehen deutlicher Widerstand gegen den Wind."));
		map.put(34, new Beaufort(8, "Stürmischer Wind", " mäßig hohe Wellenberge, lange Wellenkämme, Gischt weht überall ab, Schaumstreifen durchziehen die See", " Große Bäume schwanken, erste Zweige brechen ab, erhebliche Behinderungen beim Gehen, klappernde Fensterläden an den Häusern."));
		map.put(41, new Beaufort(9, "Sturm", "hohe Wellenberge, See beginnt zu \"rollen\", Schaumstreifen überall, Gischt beeinträchtigt die Sicht", "Äste brechen ab, erste kleinere Schäden an Häusern möglich, Ziegel werden angehoben, Gartenmöbel werden umgeworfen, Baugerüste schwanken teils erheblich, unbefestigte Kleingegenstände werden bewegt oder umgeworfen. erheblich starke Behinderung beim Gehen, Lastwagen und Anghänger werden bei Seitenwindböen aus der Spur geworfen."));
		map.put(48, new Beaufort(10, "Schwerer Sturm", "sehr hohe Wellenberge, lange überbrechende Dämme, weisse rollende See durch Schaum und Gischt, Sichtbehinderungen durch Gischt", " Bäume werden entwurzelt, Baugerüste können umfallen, Gartenmöbel werden weggeweht, größere Schäden an Häusern, Lastwagen oder Anghänger können durch Seitenwindböen umgeworfen werden."));
		map.put(56, new Beaufort(11, "Orkanartiger Sturm", "Extrem hohe Wellenberge, Wellenkämme werden zu Gischt zerblasen, die See \"rollt\" extrem schwer und ruckartig, Wellen türmen sich meterhoch, Sicht deutlich eingeschränkt.", " schwere Sturmschäden zu erwarten, in Wäldern großflächiger Windbruch möglich, Dächer werden abgedeckt, Gehen nahezu unmöglich, Autofahren lebensgefährlich, größere Schäden an Häusern, Verkehrsschilder und Ampelanlagen können beschädigt werden."));
		map.put(64, new Beaufort(12, "Orkan", "Extreme meterhohe Wellen, Luft mit Schaum und Gischt vollgefüllt, Sicht kaum noch vorhanden, See ist vollständig weiss", "Schwerste Schäden an Häusern, Wäldern und im Verkher. Aufenthalt im Freien lebensgefährlich, auch schwere unbefestigte  Gegenstände werden mitgerissen/mitgeschleift."));
		
	}
	
	public Beaufort getBeaufortFromKnots(int knots) {
		return map.floorEntry(knots).getValue();
	}
	
	public Beaufort getBeaufort(int force) {
		// iterate over map until correct beaufort is found
		for (Entry<Integer, Beaufort> b : map.entrySet()) {
			if (b.getValue().n == force) 
				return b.getValue();
		}
		return null;
	}	
	
	/* returns the min knots for the given wind force */  
	public int getKnotsFromBeaufort(int force) {
		// iterate over map until correct beafor is found
		for (Entry<Integer, Beaufort> b : map.entrySet()) {
			if (b.getValue().n == force) 
				return b.getKey();
		}
		return 0;
	}		
	
    public double convert(float inputValue, double constant) {
    	return inputValue * constant; 
    }

	public double getConversionConst() {
		return conversionConst;
	}
	
    /*
     * round to 2 decimal places
     */
    double round(double in) {
    	return (double)Math.round(in * 100) / 100;  
    }

}
