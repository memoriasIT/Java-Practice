package prAgenda;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class agenda {
	private persona[] pers;
	private static final int TAM = 10;
	private int npersonas;
	
	public agenda() {
		this(TAM);
	}
	
	public agenda(int c) {
		if (c <=0) {
			throw new IllegalArgumentException("Tamaño no valido");
		}
		npersonas = 0;
		pers = new persona[c];
	}

	public void anyadir(String n, int t) {
		this.anyadir(new persona(n, t));
	}
	
	public void anyadir(String nt) {
		String[] p = nt.split("\\s*[#;]\\s*");
		if (p.length != 2) {
			throw new IllegalArgumentException("String no valido");
		}
		this.anyadir(new persona(p[0], Integer.parseInt(p[1])));
	}
	
	public void anyadir(persona p) {
		if (npersonas == pers.length) {
			pers = Arrays.copyOf(pers, 2*pers.length);
		}
		
	}
	
	public void guardar(String nf) throws IOException{
		try (PrintWriter pw = new PrintWriter(nf)){
			for (int i = 0; i < npersonas; ++i) {
				pw.printf("%s#%s\n", pers[i].getNombre(), pers[i].gettlf());
			}
		}
	}
	
	public void cargar(String nf) throws IOException{
		try(Scanner sc = new Scanner(new File(nf))){
			while(sc.hasNextLine()) {
				String Linea = sc.nextLine();
				this.anyadir(linea);
				
			}
		} catch (IllegalArgumentException e) {
			throw new IOException("Bad Format");
		}
				
	}
	
}
