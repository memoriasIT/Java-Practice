package prAgendaMapas;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Agenda {

	private SortedMap<String,SortedSet<String>> ag;
	
	public Agenda() {
		// Comparar String mayor a menor ignorar mayusc
		this(new StringICCmp().reversed());
	}
	
	public Agenda(Comparator<String> cmp) {
		ag = new TreeMap(cmp);
	}
	
	public void add(String n, Collection<String> t) {
		SortedSet<String> tfn = ag.get(n);
		if(tfn == null) {
			tfn = new TreeSet<>(ag.comparator().reversed());
			ag.put(n, tfn);
		}
		tfn.addAll(t);
	}
	
	@Override
	public String toString() {
		// return ag.toString();
		StringBuilder str = new StringBuilder().append("[");
		for (Entry<String, SortedSet<String>> a : ag.entrySet()) {
			str.append(a.getKey()).append(":(").append(a.getValue()).append("),");
		}
		str.append("]");
		return str.toString();
		
	}
}
