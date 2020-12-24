package tn.esprit.spring.controller;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.service.IContratService;
import tn.esprit.spring.service.IEmployeService;

import java.util.*;
import tn.esprit.spring.entity.*;


@Scope(value = "session")
@Controller(value = "contratController")
@ELBeanName(value = "contratController")
@Join(path = "/contrat", to = "/contrat.jsf")

public class ContratController {
	@Autowired
	IEmployeService iEmployeService; 
	@Autowired
	IContratService iContratService;


    
private int salaire; 
private Date dateDebut; 
private String typeContrat; 
 
private int selectedEmployeId;
public int getSelectedEmployeId() {
	return selectedEmployeId;
}
  
public void setSelectedEmployeId(int selectedEmployeId) {
	this.selectedEmployeId = selectedEmployeId;
}   
   
 
private List<Employe> employes;
private List<Contrat> contrats;


public List<Contrat> getContrats() {
	contrats = iContratService.getAllContrat();
//	contrats.forEach(s->System.out.println(s.toString()));
return contrats;
} 
 
public List<Employe> getEmployes() {
employes = iEmployeService.getAllEmployes();
return employes;
}    

public void ajouterContrat(){
	Employe emp = iEmployeService.findById(selectedEmployeId);
	System.out.println(emp.toString());
	iContratService.ajouterContrat(new Contrat(selectedEmployeId,dateDebut,typeContrat,salaire,emp));
} 
  

  



public int getSalaire() {
	return salaire;
}

public void setSalaire(int salaire) {
	this.salaire = salaire;
}

public String getTypeContrat() {
	return typeContrat;
}

public void setTypeContrat(String typeContrat) {
	this.typeContrat = typeContrat;
}

public Date getDateDebut() {
	return dateDebut;
}

public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}

public void setEmployes(List<Employe> employes) {
	this.employes = employes;
}


public void setContrats(List<Contrat> contrats) {
	this.contrats = contrats;
}



}
