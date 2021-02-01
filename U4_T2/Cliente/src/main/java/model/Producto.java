package model;



import javax.persistence.*;

@Entity
@Table(name = "products")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 64, nullable = false, unique = true)
	private String nombre;
	
	@Column
	private double precio;
	
	@Column
	private String categoria;
	
	public Producto() {
		
	}

	public Producto(Integer id, String nombre, double precio,String categoria) {		
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
	public Producto(String nombre, double precio,String categoria) {		
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	

}
