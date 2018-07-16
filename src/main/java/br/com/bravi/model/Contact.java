package br.com.bravi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable{

	private static final long serialVersionUID = 3916585417675959259L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotEmpty
	@Column(name = "contact_value", nullable = false)
	private String contact_value;
	
	@NotEmpty
	@Column(name = "person_id", nullable = false)
	private Long person_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact_value() {
		return contact_value;
	}

	public void setContact_value(String contact_value) {
		this.contact_value = contact_value;
	}

	public Long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}
	
}