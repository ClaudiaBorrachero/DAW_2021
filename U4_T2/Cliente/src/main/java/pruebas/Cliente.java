package pruebas;

public class Cliente {
	
	private String nombre;
	private String apellidos;
	private String direccion;
	private double saldo;
	private TaxServicesHacienda deudaMaxima;	

	public Cliente(String nombre, String apellidos, String direccion, double sueldo, TaxServicesHacienda deudaMaxima) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.saldo = sueldo;
		this.deudaMaxima = deudaMaxima;
	}
	public double getobtenerCapacidadDeCredito() {
        return saldo*deudaMaxima(saldo);
	}
	private double deudaMaxima(double saldo2) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
