package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Entreprise implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdEntreprise")
	int id;
	String name;
	String RaisonSocial;
	@OneToMany(mappedBy="Entreprise")
	private Set<Departement> Departement;
}
