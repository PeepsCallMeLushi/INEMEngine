package pt.sali.SALI.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Avaliacao {
	
	@Id
	private String id;
	private ArrayList<Sintoma> sintomas;
	private ArrayList<String> antecedentesPessoais;
	private ArrayList<Farmaco> habitosFarmacologicos;
	private ArrayList<Estado> estado;
	private ArrayList<Dano> danos;
	
	public Avaliacao() {
		super();
		this.id = null;
		this.sintomas = new ArrayList<>();
		this.antecedentesPessoais = new ArrayList<>();
		this.habitosFarmacologicos = new ArrayList<>();
		this.estado = new ArrayList<>();
		this.danos = new ArrayList<>();
	}

	public ArrayList<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(ArrayList<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

	public ArrayList<String> getAntecedentesPessoais() {
		return antecedentesPessoais;
	}

	public void setAntecedentesPessoais(ArrayList<String> antecedentesPessoais) {
		this.antecedentesPessoais = antecedentesPessoais;
	}

	public ArrayList<Farmaco> getHabitosFarmacologicos() {
		return habitosFarmacologicos;
	}

	public void setHabitosFarmacologicos(ArrayList<Farmaco> habitosFarmacologicos) {
		this.habitosFarmacologicos = habitosFarmacologicos;
	}

	public ArrayList<Estado> getEstado() {
		return estado;
	}

	public void setEstado(ArrayList<Estado> estado) {
		this.estado = estado;
	}

	public ArrayList<Dano> getDanos() {
		return danos;
	}

	public void setDanos(ArrayList<Dano> danos) {
		this.danos = danos;
	}

	public String getId() {
		return id;
	}
	
}