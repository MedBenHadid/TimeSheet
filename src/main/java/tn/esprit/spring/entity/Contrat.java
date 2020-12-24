package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Contrat")

public class Contrat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Reference")
	int id;
	Date dateDebut;
	String typeContrat;
	int salaire;
 
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
	private Employe employe;
	
	    
	 
	
	public Contrat(int reference, Date dateDebut, String typeContrat, int salaire,Employe e) {
		super();
		id = reference;
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
		this.employe =e;
	} 
	 
	public Contrat() {
		super();
	}

	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public int getId() {
		return id;
	}
	public void setId(int reference) {
		id = reference;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", dateDebut=" + dateDebut + ", typeContrat=" + typeContrat + ", salaire="
				+ salaire + ", employe=[" + employe.toString() + "]]";
	}
	
	
}
