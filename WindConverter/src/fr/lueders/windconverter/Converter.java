package fr.lueders.windconverter;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Converter {
	
	private double conversionConst = 1.852;	
	
	private NavigableMap<Integer, Beaufort> map = new TreeMap<Integer, Beaufort>();

	public Converter() {
		map.put(0, new Beaufort(0, "Windstille", "glatte See", "Luft steht, nichts bewegt sich, Rauch steigt senkrecht nach oben"));
		map.put(1, new Beaufort(1, "leiser Zug", "kleine Kr�uselwellen", "kaum sp�rbar, leichtes S�useln der Bl�tter, Rauch wird etwas abgelenkt"));
		map.put(4, new Beaufort(2, "leichte Brise", "kurze, kleine Wellen",  "Bl�tter rascheln, Wind wird sp�rbar"));
		map.put(7, new Beaufort(3, "schwache Brise", "Wellenk�mme beginnen zu brechen, einzelne Schaumkronen", "Bl�tter und d�nne Zweige bewegen sich, Wimpel stellen sich auf, Fahnen flattern sichtbar"));
		map.put(11, new Beaufort(4, "m��ige Brise", "kleinere, l�ngere Wellen mit Schaumkronen", "Zweige bewehen sich, loses Papier und Bl�tter werden vom Boden aufgehoben"));
		map.put(16, new Beaufort(5, "frische Brise", "lange, m�ssig hohe Wellen, �berall Schaumkronen", "Gr��ere Zweige bewegen sich, B�ume wiegen sich im Wind, deutlich h�rbarer Wind"));
		map.put(22, new Beaufort(6, "starker Wind", "Gr��ere Wellen, fl�chig Schaumkronen, Wellenk�mme brechen, Gischt beginnt aufzukommen", " Dicke �ste, gro�e B�ume bewegen sich, Wind beginnt z.B. an Drahtseilen zu pfeifen"));
		map.put(28, new Beaufort(7, "steifer Wind", "Wellen t�rmen sich auf, Schaum l�st sich von den Wellenk�mmen ab", " B�ume beginnen zusehends zu schwanken, beim Gehen deutlicher Widerstand gegen den Wind."));
		map.put(34, new Beaufort(8, "St�rmischer Wind", " m��ig hohe Wellenberge, lange Wellenk�mme, Gischt weht �berall ab, Schaumstreifen durchziehen die See", " Gro�e B�ume schwanken, erste Zweige brechen ab, erhebliche Behinderungen beim Gehen, klappernde Fensterl�den an den H�usern."));
		map.put(41, new Beaufort(9, "Sturm", "hohe Wellenberge, See beginnt zu \"rollen\", Schaumstreifen �berall, Gischt beeintr�chtigt die Sicht", "�ste brechen ab, erste kleinere Sch�den an H�usern m�glich, Ziegel werden angehoben, Gartenm�bel werden umgeworfen, Bauger�ste schwanken teils erheblich, unbefestigte Kleingegenst�nde werden bewegt oder umgeworfen. erheblich starke Behinderung beim Gehen, Lastwagen und Angh�nger werden bei Seitenwindb�en aus der Spur geworfen."));
		map.put(48, new Beaufort(10, "Schwerer Sturm", "sehr hohe Wellenberge, lange �berbrechende D�mme, weisse rollende See durch Schaum und Gischt, Sichtbehinderungen durch Gischt", " B�ume werden entwurzelt, Bauger�ste k�nnen umfallen, Gartenm�bel werden weggeweht, gr��ere Sch�den an H�usern, Lastwagen oder Angh�nger k�nnen durch Seitenwindb�en umgeworfen werden."));
		map.put(56, new Beaufort(11, "Orkanartiger Sturm", "Extrem hohe Wellenberge, Wellenk�mme werden zu Gischt zerblasen, die See \"rollt\" extrem schwer und ruckartig, Wellen t�rmen sich meterhoch, Sicht deutlich eingeschr�nkt.", " schwere Sturmsch�den zu erwarten, in W�ldern gro�fl�chiger Windbruch m�glich, D�cher werden abgedeckt, Gehen nahezu unm�glich, Autofahren lebensgef�hrlich, gr��ere Sch�den an H�usern, Verkehrsschilder und Ampelanlagen k�nnen besch�digt werden."));
		map.put(64, new Beaufort(12, "Orkan", "Extreme meterhohe Wellen, Luft mit Schaum und Gischt vollgef�llt, Sicht kaum noch vorhanden, See ist vollst�ndig weiss", "Schwerste Sch�den an H�usern, W�ldern und im Verkher. Aufenthalt im Freien lebensgef�hrlich, auch schwere unbefestigte  Gegenst�nde werden mitgerissen. mitgeschleift."));
		
	}
	
	public Beaufort getBeaufort(int knots) {
		return map.floorEntry(knots).getValue();
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
