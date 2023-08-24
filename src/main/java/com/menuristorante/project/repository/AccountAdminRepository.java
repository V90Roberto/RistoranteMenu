package com.menuristorante.project.repository;






import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menuristorante.project.model.AccountAdmin;


@Repository
public interface AccountAdminRepository extends JpaRepository <AccountAdmin, Long>{
	
	 Optional<AccountAdmin> findByEmailRistorante(String email_ristorante);
	 

	

}
