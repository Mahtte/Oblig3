import java.util.ArrayList;

public class KortTest {

	public static void main(String[] args) {

		ArrayList<Kort> reg = new ArrayList<Kort>();

		Kort k1 = new Ansatt("Ole", "Olsen", 1234);
		Kort k2 = new Gjest("Marit", "Olsen");
		Kort k3 = new Gjest("Per Ivar", "Bakke");
		Kort k4 = new Ansatt("Agnethe", "Bucka", 4455);
		reg.add(k1);
		reg.add(k2);
		reg.add(k3);
		reg.add(k4);

		for (int i = 0; i < reg.size(); i++) {
			Kort kort = (Kort) reg.get(i);
			System.out.print(kort);
			System.out.println("\nTest av kort: med kode 1234 er"
					+ (kort.sjekkPIN(1234) ? " gyldig" : " ugyldig"));
			System.out.println("\nTest av kort: med kode 9999 er"
					+ (kort.sjekkPIN(9999) ? " gyldig" : " ugyldig"));
		}
		
		java.util.Collections.sort(reg);
		System.out.println(reg);
		
		Kort k5 = (Kort)k4.clone();
		System.out.println(k5);
		


	}

}
