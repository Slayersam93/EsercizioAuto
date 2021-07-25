package it.epicode.be.Garage.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chiavePersona")
	@SequenceGenerator(name = "chiavePersona", sequenceName = "persona_seq", allocationSize = 1)
	private long id;
	private String nome;
	private String cogmone;
	@OneToMany(mappedBy = "proprietario")
	List<Automobile> automobili;

	public Persona() {
	}

	public Persona(String nome, String cogmone) {
		this.nome = nome;
		this.cogmone = cogmone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCogmone() {
		return cogmone;
	}

	public void setCogmone(String cogmone) {
		this.cogmone = cogmone;
	}

	public List<Automobile> getAutomobili() {
		return automobili;
	}

	public void setAutomobili(List<Automobile> automobili) {
		this.automobili = automobili;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cogmone=" + cogmone + "]";
	}

}
