package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employe implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;
private String login;
private String password;
private String email;
private Boolean isActif;
private String prenom;
private String nom;
@Enumerated(EnumType.STRING)
//@NotNull
private Role role;

@OneToOne(mappedBy = "employe", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private Contrat contrat;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "Temploye", joinColumns={@JoinColumn(name="IDEmploye")}, inverseJoinColumns={@JoinColumn(name ="IdDEP")})
private Set<Departement> Departements;
  
 
@OneToMany(mappedBy="Employes")
private List<Timesheet>timesheets;

public Employe(String login, String password,String email, Role role, Boolean isActif,String prenom,String nom) {
super();
this.login = login;
this.password = password;
this.prenom =prenom;
this.nom = nom;
this.email = email;
this.role = role;
this.isActif = isActif;
}

public Employe(Integer employeIdToBeUpdated, String login, String password,String email, Boolean isActif,Role role,String prenom,String nom) {
super();
this.id=employeIdToBeUpdated;

this.login = login;
this.password = password;
this.prenom =prenom;
this.nom = nom;
this.email = email;
this.role = role;
this.isActif = isActif;
}
public String getLogin() {
	return login;
}
public Boolean getIsactif() {
	return isActif;
}
public void setIsactif(Boolean isActif) {
	this.isActif = isActif;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public Employe() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Boolean getIsActif() {
	return isActif;
}
public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

@Override
public String toString() {
	return "Employe [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + "]";
}


}
