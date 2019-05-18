package prAgendaMap;
import java.util.*;

public class Agenda {
	private Map<String, Set<String>> ag;
	public Agenda() {
		ag = new HashMap<>();
	}
	
	public Set<String> get(String n){
		Set<String> t = ag.get(n);
		if (t == null) {
			throw new NoSuchElementException(n);
		}
		return t;
	}

	public void add(String n, String t) {
			Set <String > tfn = ag.get(n);
			if (tfn == null) {
				// Persona no registrada, añadir persona y telefonos
				tfn = new HashSet<>();
				ag.put(n, tfn);
			}
			tfn.add(t);
	}

	public void rem(String n, String t) {
		Set<String> tfn = ag.get(n);
		if (tfn == null) {
			throw new NoSuchElementException();
		}
		if (!tfn.remove(t)) {
			throw new NoSuchElementException(); 
		}
		
		if (tfn.isEmpty()) {
			ag.remove(n);
		}
	}

	@Override
	public String toString() {
		//return ag.toString();
		
//		StringJoiner sj = new StringJoiner(", ", "{", "}") ;
//		for (String n : ag.keySet()) {
//			StringJoiner sjp = new StringJoiner(", ", "("+n+"[", "]");
//			for (String t : ag.get(n)) {
//				sjp.add(t);
//			}
//			sj.add(sjp.toString());
//		}
//		return sj.toString();

//		StringJoiner sj = new StringJoiner(", ", "{", "}") ;
//		for (String n : ag.keySet()) {
//			sj.add("("+n+","+ag.get(n)+")");
//		}
//		return sj.toString();

		StringJoiner sj = new StringJoiner(", ", "{", "}") ;
		// Entry devuelve dos valores
		for (Map.Entry<String, Set<String>> e : ag.entrySet()) {
			sj.add("("+e.getKey()+","+e.getValue()+")");
		}
		return sj.toString();
		
	}
	
	
	
}


