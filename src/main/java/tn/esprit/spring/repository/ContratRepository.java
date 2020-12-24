package tn.esprit.spring.repository;
import org.springframework.data.repository.CrudRepository;
import java.util.*;


import tn.esprit.spring.entity.*;
public interface ContratRepository extends CrudRepository<Contrat, Integer>  {

	   List<Contrat> findAll();
}
