package prBanco;

public class Main {
	public static void main(String[] args) {
		try {
			Cuenta c;
			try {
				c = new Cuenta(args[0], Integer.parseInt(args[1]), Double.parseDouble(args[2]));
			} catch (SaldoNegativoException e) {
				c = new Cuenta(args[0], Integer.parseInt(args[1]), 0.0);
			}
			c.ingresar(Double.parseDouble(args[3]));
			for (int i = 4; i < args.length; ++i) {
				try {
					c.extraer(Double.parseDouble(args[i]));
				} catch (ExtraerNegativoException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println(c);
		} catch (CuentaException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No hay argumentos suficientes al programa");
		} catch (NumberFormatException e) {
			System.out.println("Error de formato numérico");
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			System.out.println("Fin del programa");
		}
	}
}
