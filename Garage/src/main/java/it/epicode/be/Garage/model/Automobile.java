package it.epicode.be.Garage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Automobile {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE , generator = "chiaveAuto")
	@SequenceGenerator (name = "chiaveAuto", sequenceName = "auto_seq", allocationSize = 1)
	private long id;
	private String modello;
	private String marca;
	private String numeroTelaio;
	private Colore colore; 
	@ManyToOne
	private Persona proprietario;
	
	public Automobile() {}
	public Automobile(String modello, String marca, String numeroTelaio, Colore colore, Persona proprietario) {
		this.modello = modello;
		this.marca = marca;
		this.numeroTelaio = numeroTelaio;
		this.colore = colore;
		this.proprietario = proprietario;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNumeroTelaio() {
		return numeroTelaio;
	}
	public void setNumeroTelaio(String numeroTelaio) {
		this.numeroTelaio = numeroTelaio;
	}
	public Colore getColore() {
		return colore;
	}
	public void setColore(Colore colore) {
		this.colore = colore;
	}
	public Persona getProprietario() {
		return proprietario;
	}
	public void setProprietario(Persona proprietario) {
		this.proprietario = proprietario;
	}
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Automobile [id=" + id + ", modello=" + modello + ", marca=" + marca + ", numeroTelaio=" + numeroTelaio
				+ ", colore=" + colore + ", proprietario=" + proprietario + "]";
	}
	
	
	
	

}
