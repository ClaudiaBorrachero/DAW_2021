package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class TestMockitoEmpleado {
	TaxServicesHacienda servicioRetencion = mock(TaxServicesHacienda.class);	
	
	@Test
	public void testGetSalarioBruto() {
		
		when(servicioRetencion.retencion(2000.0)).thenReturn(400.0);
		Cliente e = new Cliente("Lucas","Méndez","Calle Cádiz",2000,servicioRetencion);		
		assertEquals(1600,e.getobtenerCapacidadDeCredito());
		verify(servicioRetencion).retencion(2000);
		
	}


	
	

}
