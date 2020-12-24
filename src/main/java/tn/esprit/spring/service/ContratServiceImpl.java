package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.ContratRepository;
import java.util.*;


@Service
public class ContratServiceImpl implements IContratService
{   

@Autowired
ContratRepository contratRepository;


public List<Contrat> getAllContrat() {
	List<Contrat> con = (List<Contrat>) contratRepository.findAll();
	return con;
}


public void ajouterContrat(Contrat c){
System.out.println(c.toString());
contratRepository.save(c);
}

 
}
