package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MissionExterne")

public class MissionExtrene extends Mission implements Serializable {

	String emailFacturation;
    int	tauxJournalierMoyen;
}
