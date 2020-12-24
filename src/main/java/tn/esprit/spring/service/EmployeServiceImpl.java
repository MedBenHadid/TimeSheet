package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.repository.EmployeRepository;
import java.util.*;
import java.util.*;
import java.util.*;

@Service

public class EmployeServiceImpl implements IEmployeService
{   

@Autowired
EmployeRepository employeRepository;


public Employe getEmployeByEmailAndPassword(String login, String password) {

return employeRepository.getEmployeByEmailAndPassword(login, password);
}
public Employe findById(int id) {
	return employeRepository.findById(id);
	
}

public void ajouterEmploye(Employe e){

employeRepository.save(e); 
}  

public List<Employe> getAllEmployes() {
List<Employe> emp = (List<Employe>) employeRepository.findAll();
return emp;
}
public void deleteEmploye(int employeid) {
employeRepository.deleteById(employeid);
}
public void updateEmploye(Employe e) {
employeRepository.save(e);
}
}
