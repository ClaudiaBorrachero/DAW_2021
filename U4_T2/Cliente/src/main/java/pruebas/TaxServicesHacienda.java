package pruebas;

public interface TaxServicesHacienda {
	
	public default double retencion(double saldo) {
		return 0;
	}

}
