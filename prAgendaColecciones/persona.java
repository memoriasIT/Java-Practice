package prAgendaColecciones;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class persona {
	protected String nombre;
	protected Set<String> telefonos;
	
	public persona(String n, Collection<String> c) {
		nombre = n;
		telefonos = new HashSet<String>(c);
	}
	
	public persona(String n) {
		nombre = n;
		telefonos = new HashSet<String>();
	}
	
	public void add(String t) {
		telefonos.add(t);
	}
	
	public void add(Collection<String> t) {
		telefonos.addAll(t);
	}
	
	public void rem(String t) {
//		boolean ok = false;
//		Iterator<String> it = telefonos.iterator();
//		while (it.hasNext() && !ok) {
//			String e = it.next();
//			if (e.equals(t)) {
//				it.remove();
//				ok = true;
//			}
//		}
//		
		// Funciona con equals no con equals ignore case
		// Tendriamos que programar con lo de arriba o poner los telefnonos en mayusculas
		telefonos.remove(t);
	}
	
	public void rem(Collection<String> t) {
		// AUTOMATICO
		//telefonos.removeAll(t);
		
		// MANUAL
		Iterator<String> it = telefonos.iterator();
		while (it.hasNext()) {
			String e = it.next();
			if (t.contains(e)) {
				it.remove();
			}
		}
	}
	
	
	
	@Override
	public String toString() {
//		StringBuilder persstr = new StringBuilder().append("[ Nombre: ");
//		persstr.append(nombre).append("; Teléfonos");
//		for (String x : telefonos) {
//			persstr.append(x).append(" - ");
//		}
//		return persstr.toString();

		return "(" + nombre +", " + telefonos + ")";
	}
	
	
	@Override
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof persona) {
			persona x = (persona) o;
			res = nombre.equalsIgnoreCase(x.nombre);
		}
		return res;
	}

	@Override
	public int hashCode() {
		return nombre.toLowerCase().hashCode();
	}

	public Collection<String> gettfn() {
		return telefonos;
	}

	public String getNombre() {
		return nombre;
	}









}











