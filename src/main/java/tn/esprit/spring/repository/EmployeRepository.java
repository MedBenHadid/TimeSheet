package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Employe;
import org.springframework.stereotype.Repository;
public interface EmployeRepository extends CrudRepository<Employe, Integer>  {

    @Query("select e from Employe e where e.login=:login and e.password=:password")
    public Employe getEmployeByEmailAndPassword(@Param("login")String login, @Param("password")String password);
    
    Employe findById(int id);
    
}
