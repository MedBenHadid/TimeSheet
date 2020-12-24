package tn.esprit.spring.controller;
import tn.esprit.spring.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import org.ocpsoft.rewrite.el.ELBeanName;

@Scope(value = "session")
@Controller(value = "data")
@ELBeanName(value = "data")
public class Data {
	public Role[] getRoles(){
		return Role.values();
		}
}