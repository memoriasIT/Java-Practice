package prAgendaColecciones;
import java.util.*;

public class Agenda {
	private HashSet<persona> personas;
	
	public Agenda() {
		personas = new HashSet<persona>();
	}
	
	public void add(String a, Collection<String> b) {
		persona p = new persona(a,b);
		
		// Reemplazar la persona antigua por la nueva
//		if (personas.contains(p)) {
//			personas.remove(p);
//			personas.add(p);
//		} else {
//			personas.add(p);
//		}
		
		// Solo colocar los nuevos telefonos
		persona x = buscar(p);
		if (x == null) {
			personas.add(p);
			x = p;
		}
		
		x.add(b);
	}
	
	public void add(String a) {
		ArrayList<String> pers = new ArrayList<String>();
		pers.addAll(Arrays.asList(a.split(";")));
		String n = pers.get(0);
		pers.remove(0);
		
		add(n,pers);
	}
	
	public void addAll(Agenda a) {
		// Si ya está no lo añade
//		personas.addAll(a.personas);
		
		
		for (persona p : a.personas) {
			this.add(p.getNombre(), p.gettfn());
		}
	}
	
	
	public void remove(String a){
//		Iterator<persona> it = personas.iterator();
//		while(it.hasNext()) {
//			persona i = it.next();
//			if (a.equals(i.nombre)) {
//				personas.remove(i);
//			}
//		}
		
		personas.remove(new persona(a));
	}
	
	
	private persona buscar(persona p) {
		boolean res = false;
		Iterator<persona> it = personas.iterator();
		persona i = null;
		while(it.hasNext() && res == false) {
			i = it.next();
			res = p.equals(i);
		}
		if (!res) {
			i = null;
		}
		return i;
	}
	
	public void remove(String a, Collection<String> b) throws Exception{
		persona p = new persona(a);
		persona x = buscar(p);
		if (x == null) {
			throw new Exception();
			
		}
		x.rem(b);
		if (x.gettfn().isEmpty()) {
			personas.remove(x);
		}
	}
	
	
	public void rem(String n, String t) throws Exception {
		Collection<String> c = new HashSet<String>();
		c.add(t);
		remove(n,c);	
	}
	
	@Override
	public String toString() {
		return personas.toString();
		
//		Iterator<persona> it = personas.iterator();
//		StringBuilder str = new StringBuilder().append("{ ");
//		while(it.hasNext()) {
//			persona i = it.next();
//			str.append(i.toString());
//		}
//		return str.append(" } ").toString();
		
		
//		StringJoiner sj = new StringJoiner(",", "[", "]");
//		for (persona p : personas) {
//			sj.add(p.toString());
//		}
//		return sj.toString();
	}
	
	
	@Override
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Agenda) {
			Agenda x = (Agenda) o;
			res = personas.equals(x.personas);
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return personas.hashCode();
	}
	
	
	public Collection<String> get(String n) throws Exception{
		persona p = new persona(n);
		persona x = buscar(p);
		if (x == null) {
			throw new Exception();
		}
		return x.gettfn();
	}
	
}
