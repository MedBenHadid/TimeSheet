package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Departement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	String name;
	@ManyToMany(mappedBy="Departements", cascade = CascadeType.ALL)
	private Set<Employe> Employes;
	 @ManyToOne
	 @JoinColumn(name="Entreprise")
	 Entreprise Entreprise;
	 @OneToMany(mappedBy="Departement")
		private Set<Mission> Mission;

}
