package com.dalel.vetements.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class vetements {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVetements;
	private String nomVetements;
	private Double prixVetements;
	private Date dateProduction;
	private String description;
	public vetements() {
		super();
	
	}
	public vetements(Long idVetements, String nomVetements, Double prixVetements, Date dateProduction,
			String description) {
		super();
		this.idVetements = idVetements;
		this.nomVetements = nomVetements;
		this.prixVetements = prixVetements;
		this.dateProduction = dateProduction;
		this.description = description;
	}
	
	public Long getIdVetements() {
		return idVetements;
	}
	public void setIdVetements(Long idVetements) {
		this.idVetements = idVetements;
	}
	public String getNomVetements() {
		return nomVetements;
	}
	public void setNomVetements(String nomVetements) {
		this.nomVetements = nomVetements;
	}
	public Double getPrixVetements() {
		return prixVetements;
	}
	public void setPrixVetements(Double prixVetements) {
		this.prixVetements = prixVetements;
	}
	public Date getDateProduction() {
		return dateProduction;
	}
	public void setDateProduction(Date dateProduction) {
		this.dateProduction = dateProduction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "vetements [idVetements=" + idVetements + ", nomVetements=" + nomVetements + ", prixVetements="
				+ prixVetements + ", dateProduction=" + dateProduction + ", description=" + description + "]";
	}
	
	


}
