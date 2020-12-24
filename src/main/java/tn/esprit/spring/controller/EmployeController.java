package tn.esprit.spring.controller;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import ch.qos.logback.classic.Logger;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.service.IEmployeService;

import java.io.Console;
import java.util.*;


@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")
 
public class EmployeController {
     
@Autowired
IEmployeService iEmployeService;
  
private Employe employe;
private Boolean loggedIn;

private String login; 
private String password; 
private String email; 
private Boolean isActif;
private Role role;
private String prenom;
private String nom;
private List<Employe> employes;
private Integer employeIdToBeUpdated; 
public String dologin() {

String navigateTo = "null";
Employe employe=iEmployeService.getEmployeByEmailAndPassword(login, password);
if (employe != null && employe.getRole() == Role.ADMINISTRATEUR) {
navigateTo = "/welcome.xhtml?faces-redirect=true";
loggedIn = true;
}
else
{
FacesMessage facesMessage =
                new FacesMessage("Login Failed: please check your username/password and try again.");
            FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
}
return navigateTo;
}




public Boolean getIsActif() {
	return isActif;
}




public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
}


public void ajouterEmploye(){
iEmployeService.ajouterEmploye(new Employe(login,password, email, role, isActif,prenom,nom));
}


public List<Employe> getEmployes() {
employes = iEmployeService.getAllEmployes();
return employes;
}

public void setEmployes(List<Employe> employes) {
	this.employes = employes;
}

public Role getRole() {
	return role;
}


public void mettreAjourEmploye(){
	System.out.println(login);

Employe e= new Employe(employeIdToBeUpdated,login,password, email, isActif, role,prenom,nom);
iEmployeService.updateEmploye(e);

}

public void modifier(Employe employe)
{
this.setEmail(employe.getEmail());
this.setIsActif(employe.getIsActif());
this.setLogin(employe.getLogin());
this.setNom(employe.getNom());
this.setPrenom(employe.getPrenom());
this.setPassword(employe.getPassword());
this.setRole(employe.getRole());
this.setEmployeIdToBeUpdated(employe.getId());

}

public Integer getEmployeIdToBeUpdated() {
	return employeIdToBeUpdated;
}




public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
	this.employeIdToBeUpdated = employeIdToBeUpdated;
}




public void setRole(Role role) {
	this.role = role;
}

public void removeEmploye(int employeid)
{
iEmployeService.deleteEmploye(employeid);
}


public String doLogout()
{FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/login.xhtml";
}

//Générer les Getters & les Setters



public IEmployeService getiEmployeService() {
	return iEmployeService;
}

public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}





public void setiEmployeService(IEmployeService iEmployeService) {
	this.iEmployeService = iEmployeService;
}



public String getLogin() {
	return login;
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



public Employe getEmploye() {
	return employe;
}



public void setEmploye(Employe employe) {
	this.employe = employe;
}



public Boolean getLoggedIn() {
	return loggedIn;
}



public void setLoggedIn(Boolean loggedIn) {
	this.loggedIn = loggedIn;
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
    
}
