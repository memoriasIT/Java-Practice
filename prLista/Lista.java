package prLista;

import java.util.Arrays;
import java.util.StringBuilder;
import java.util.StringJoiner;

public class Lista<E> {
	private int nElms;
	private E[] elms;
	public Lista(E[] e) {
		if (e == null || e.length == 0) {
			throw new IllegalArgumentException("Bad Arguments");
		}
		nElms = 0;
		elms = e;
	}
	
	// SuppessWarnings para indicar que no es erróneo
	@SuppressWarnings("unchecked")
	public Lista() {
		nElms = 0;
		//CREAR ARRAY DE TIPO OBJECT PORQUE DE TIPO GENÉRICO NO ES POSIBLE
		// Se hace casting con objeto genérico
		elms = (E[]) new Object[16];
		
	}
	
	public void add(E e) {
		if (elms.length == nElms) {
			elms = Arrays.copyOf(elms, 2*elms.length);
			elms[nElms] = e;
			++nElms;
		}
	}
	
	
	public E get(int pos) {
		if (pos < 0 || pos >= nElms) {
			throw new IllegalArgumentException("Bad args");
		} else {
			return elms[pos];
		}
	}
	
	public E remove(int pos) {
		if (pos < 0 || pos >= nElms) {
			throw new IllegalArgumentException("Bad args");
		} else {
			E e = elms[pos];
			System.arraycopy(elms, pos+1, elms, pos, nElms-pos+1);
			--nElms;
			return e;
		}		
	}
	
	public int search(E e) {
		int i = 0;
		
		// Metodo equals de e no de de la clase Lista
		while (i < nElms && !e.equals(elms[i])) {
			++i;
		}
		if (i == nElms) {
			i = -1;
		}
		return i;
	}
	
	public void addAll(Lista<? extends E> e) {
		if (e == null) {
			throw new IllegalArgumentException("Not valid input");
		}
		
//		for (int i = 0; i < e.nElms; i++) {
//			this.add(e.elms[i]);
//		}
		
		if (nElms + e.nElms > elms.length) {
			elms = Arrays.copyOf(elms, nElms+e.nElms+10);
		}
		System.arraycopy(e.elms, 0, elms, nElms, e.nElms);
	}
	

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ");
		for (int i = 0; i < nElms; i++) {
			sj.add(elms[i].toString());
		}
		return sj.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = false;
		// instance of no se puede con parámetros genéricos pero si con anónimos (?)
		if (o instanceof Lista<?>) {
			Lista<?> l = (Lista<?>) o;
			if (nElms == l.nElms) {
				int i = 0;
				while ((i < nElms) && l.elms[i].equals(elms[i])) {
					i++;
				}
				res = (i == nElms);
			}
		}
		
		return res; 
	}

	@Override
	public int hashCode() {
		int h = nElms;
		for (int i = 0; i < nElms; i++) {
			h = 31 * h + elms[i].hashCode();
		}
		
		return h;
	}
	
	
	
	
}
