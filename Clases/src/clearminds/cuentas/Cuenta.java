package clearminds.cuentas;

public class Cuenta {
	private String id;
	private String tipo;
	private double saldo;

	public Cuenta(String idCuenta) {
		this.id = idCuenta;
		this.tipo = "A";
	}

	public Cuenta(String idCuenta, String tipo, double saldo) {
		this.id = idCuenta;
		this.tipo = tipo;
		this.saldo = saldo;
	}

	public void imprimir() {
		System.out.println("*****************************");
		System.out.println("          CUENTA");
		System.out.println("*****************************");
		System.out.println("Numero de Cuenta: " + id);
		System.out.println("Tipo: " + tipo);
		System.out.println("Saldo: USD " + saldo);
		System.out.println("*****************************");
	}

	public void imprimirConMiEstilo() {
		System.out.println("=============================");
		System.out.println("===CLEARMINDS CONSULTORES====");
		System.out.println("=============================");
		System.out.println("                             ");
		System.out.println("------------CUENTA-----------");
		System.out.println("                             ");
		System.out.println("=============================");
		System.out.println("||   Numero de Cuenta: " + id+" ||");
		System.out.println("||   Tipo: " + "(" + tipo + ") ||");
		System.out.println("||   Saldo: USD " + saldo + "$ ||");
		System.out.println("=============================");
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getId() {
		return id;
	}

}
