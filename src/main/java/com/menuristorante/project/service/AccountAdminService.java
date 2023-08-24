package com.menuristorante.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuristorante.project.model.AccountAdmin;
import com.menuristorante.project.repository.AccountAdminRepository;

@Service
public class AccountAdminService {
	
	@Autowired
	private  AccountAdminRepository 
	                                accountAdminRepository;
	
	
	/*public  AccountAdminService(AccountAdminRepository aAr) {
		this.aAr =aAr;
	}*/
	
    public void save(AccountAdmin ac) {
    	AccountAdmin aC = new AccountAdmin();
    	aC = accountAdminRepository.save(ac);
    	System.out.println("save: " + aC);
    }
    
    public void update(AccountAdmin ac) {
    	AccountAdmin searchId = new AccountAdmin();
    	
    	if(ac.getId() != null) {
    	   searchId=  accountAdminRepository.save(ac);
    	}
    	
    	System.out.println("update: " + searchId);
    }
    
    public void deleteAll(AccountAdmin ac) {
    	accountAdminRepository.deleteAll();
    	
    }
    
    public void delete(AccountAdmin ac) {
    	accountAdminRepository.delete(ac);
    }
    
    public void findAccountAdminById(Long id) {
    	accountAdminRepository.findById(id);
    }
    
    public Optional<AccountAdmin> findyByEmailRistorante(String email_ristorante) {
		return accountAdminRepository.findByEmailRistorante(email_ristorante);
    	
    }
    
    public boolean checkEmailAndPassword(String email_ristorante, String password_ristorante) {
        Optional<AccountAdmin> accountAdminOptional = accountAdminRepository.findByEmailRistorante(email_ristorante);
        
        if (accountAdminOptional.isPresent()) {
            AccountAdmin accountAdmin = accountAdminOptional.get();
            return accountAdmin.getPasswordRistorante().equals(password_ristorante);
        }
        
        return false;
    }
    
    public boolean isAdmin(AccountAdmin accountAdmin) {
        return "admin".equals(accountAdmin.getRole());
    }
    
    public void createNonAdminAccount(AccountAdmin admin, AccountAdmin nonAdmin) {
        if (isAdmin(admin)) {
            // Logica per creare un account non amministratore
             accountAdminRepository.save(nonAdmin);
        } else {
            throw new RuntimeException("L'account non ha i permessi necessari per creare un account non amministratore.");
        }
    }
    
    public void updateNonAdminAccount(AccountAdmin admin, AccountAdmin nonAdmin) {
        if (isAdmin(admin)) {
            // Logica per aggiornare un account non amministratore
        } else {
            throw new RuntimeException("L'account non ha i permessi necessari per aggiornare un account non amministratore.");
        }
    }
    
    public void deleteNonAdminAccount(AccountAdmin admin, AccountAdmin nonAdmin) {
        if (isAdmin(admin)) {
            // Logica per eliminare un account non amministratore
        	accountAdminRepository.delete(nonAdmin);
        } else {
            throw new RuntimeException("L'account non ha i permessi necessari per eliminare un account non amministratore.");
        }
    }

}
