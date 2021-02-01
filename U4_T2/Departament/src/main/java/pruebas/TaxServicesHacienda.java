package pruebas;

public interface TaxServicesHacienda {
	
	public default double retencion(double numEmpleados) {
		return 0;
	}

}
