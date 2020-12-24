package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Timesheet implements Serializable{
	@ManyToOne
	@JoinColumn(name="idM",referencedColumnName="idMission",insertable=false,updatable=false)
 private Mission Missions;
	@ManyToOne
	@JoinColumn(name="idEmploye",referencedColumnName="id",insertable=false,updatable=false)
 private Employe Employes;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdTime")
	private int id;
 private Date DateDebut;
 private Date DateFin;
 private boolean IsValid;
}
