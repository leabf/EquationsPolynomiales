import java.util.ArrayList;

public class resolution {

	public static void main(String[] args) {
		
	}
	
	private ArrayList<String> premierDegre(double a, double b) {
		ArrayList<String> racine = new ArrayList<>();
		racine.add(Double.toString(-b/a));
		return racine;
	}
	
	private ArrayList<String> secondDegre(double a, double b, double c) {
		ArrayList<String> racines = new ArrayList<>();
		if (a == 0) {
			racines.addAll(premierDegre(b, c));
			return racines;
		} 
		
		double delta = (b*b)-(4*a*c);
		if (delta > 0) {
			racines.add(Double.toString((-b-Math.sqrt(delta))/2*a));
			racines.add(Double.toString((-b+Math.sqrt(delta))/2*a));
		} else if (delta == 0) {
			racines.add(Double.toString(-b/2*a));
		} else if (delta < 0) {
			double partieReelle = -b/2*a;
			double partieImaginaire = Math.sqrt(-delta)/2*a;
			racines.add(Double.toString(partieReelle) + "+i" + Double.toString(Math.abs(partieImaginaire)));
			racines.add(Double.toString(partieReelle) + "-i" + Double.toString(Math.abs(partieImaginaire)));
		}
		
		return racines;
	}
	
	private ArrayList<String> troisiemeDegre(int a, int b, int c, int d) {
		ArrayList<String> racines = new ArrayList<>();
		if (a == 0) {
			racines.addAll(secondDegre(b, c, d));
			return racines;
		} 
		
		double p = Math.pow(-b, 2)/3*Math.pow(a, 2)+c/a;
		double q = b/27*a*(2*Math.pow(b, 2)/Math.pow(a, 2)-9*c/a)+d/a;
		double moinsBSur3A = -b/3*a;

		if (p == 0) {
			if (q == 0) {
				racines.add(Double.toString(moinsBSur3A));
			} else {
				racines.add(Double.toString(Math.cbrt(-q)));				
			}
			return racines;
		} else if (q == 0) {
			racines.addAll(secondDegre(1, 0, p));
			racines.add(Double.toString(0));
			return racines;
		}
		
		double delta = -(27*Math.pow(q, 2) + 4*Math.pow(p, 3));
		double deltaPrime = delta/27;
		
		if (delta > 0) {
			double u = Math.cbrt((-q+Math.sqrt(deltaPrime))/2);
			double v = Math.cbrt((-q-Math.sqrt(deltaPrime))/2);
			
			//une solution réelle
			racines.add(Double.toString(u+v+moinsBSur3A));
			
			//deux solutions complexes conjuguées
			double partieReelle = -0.5*(u+v)+moinsBSur3A;
			double partieImaginaire = (Math.sqrt(3)/2)*(u+v);
			racines.add(Double.toString(partieReelle)+"+i"+Double.toString(Math.abs(partieImaginaire)));				
			racines.add(Double.toString(partieReelle)+"-i"+Double.toString(Math.abs(partieImaginaire)));
		} else if (delta == 0) {
			racines.add(Double.toString(3*q/p+moinsBSur3A));
			racines.add(Double.toString(-3*q/2*p+moinsBSur3A));
		} else {
			double u = Math.cbrt((-q+Math.sqrt(deltaPrime))/2);
			double v = Math.cbrt((-q-Math.sqrt(deltaPrime))/2);
			
			//une solution réelle
			racines.add(Double.toString(u+v+moinsBSur3A));
			
			//deux solutions complexes conjuguées
			double partieReelle = -0.5*(u+v)+moinsBSur3A;
			double partieImaginaire = (Math.sqrt(3)/2)*(u-v);
			racines.add(Double.toString(partieReelle)+"+i"+Double.toString(Math.abs(partieImaginaire)));				
			racines.add(Double.toString(partieReelle)+"-i"+Double.toString(Math.abs(partieImaginaire)));
		}
		
		return racines;
	}

}
