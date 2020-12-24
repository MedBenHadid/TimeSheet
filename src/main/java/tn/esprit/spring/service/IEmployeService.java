package tn.esprit.spring.service;

import tn.esprit.spring.entity.Employe;
import java.util.*;

public interface IEmployeService {
	public Employe getEmployeByEmailAndPassword(String login, String password) ;
	public void ajouterEmploye(Employe e) ;
	public List<Employe> getAllEmployes();
	public Employe findById(int employeid);
	public void deleteEmploye(int employeid);
	public void updateEmploye(Employe e);
}
