package com.menuristorante.project.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountAdmin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;
	private String nome_ristorante;
	private String user_ristorante;
	@Column(name="password_ristorante")
	private String passwordRistorante;
	@Column(name="email_ristorante")
	private String emailRistorante;
	
	
	
	
	
	

}
