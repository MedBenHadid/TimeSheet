package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Mission implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMission")
	int id;
	String name;
	String Description;
	@OneToMany(mappedBy="Missions")
	 private List<Timesheet>timesheets;
	 @ManyToOne
	 @JoinColumn(name="Departement")
	Departement Departement;
}
