package pruebas;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class TestMockitoDepartamento {
	TaxServicesHacienda servicioRetencion = mock(TaxServicesHacienda.class);	
	
	@Test
	public void testGetSalarioBruto() {
		
		when(servicioRetencion.retencion(2000.0)).thenReturn(400.0);
		Departamento e = new Departamento("Lucía","Márquez",2000);	
		
	}


	
	

}
