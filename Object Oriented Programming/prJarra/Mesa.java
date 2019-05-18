package prJarra;

public class Mesa {
	Jarra jarraA, jarraB;
	
	public Mesa(Jarra a, Jarra b) {
		jarraA = a; 
		jarraB = b;
	}
	
	public Mesa(int a, int b) {
		jarraA = new Jarra(a);
		jarraB = new Jarra(b);
	}
	
	public int capacidad(int a) {
		if (a > 2 || a < 1) {
			throw new JarraNotFoundException("Not valid argument");
		}
		if (a == 1) {
			return jarraA.capacidad();
		} else {
			return jarraB.capacidad();
		}
	}
	
	
	public int contenido(int a) {
		if (a > 2 || a < 1) {
			throw new  JarraNotFoundException("Not valid argument");
		}
		if (a == 1) {
			return jarraA.contenido();
		} else {
			return jarraB.contenido();
		}
	}
	
	public void llena(int a) {
		if (a > 2 || a < 1) {
			throw new JarraNotFoundException("Not valid argument");
		}
		if (a == 1) {
			jarraA.llena();
		} else {
			jarraB.llena();
		}
	}
	
	public void vacia(int a) {
		if (a > 2 || a < 1) {
			throw new JarraNotFoundException("Not valid argument");
		}
		if (a == 1) {
			jarraA.vacia();
		} else {
			jarraB.vacia();
		}
	}
	
	public void llenaDesde(int a) {
	
		switch (a) {
		case 1: jarraB.llenaDesde(jarraA); break;
		case 2: jarraA.llenaDesde(jarraB); break;
		default: throw new JarraNotFoundException("Identificador erróneo");
		}
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("M(");
		str.append(jarraA);
		str.append(jarraB);
		return str.toString();
	}
	
}
