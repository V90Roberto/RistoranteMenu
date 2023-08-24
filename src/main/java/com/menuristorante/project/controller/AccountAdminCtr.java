package com.menuristorante.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menuristorante.project.model.AccountAdmin;
import com.menuristorante.project.service.AccountAdminService;

@RestController
@RequestMapping("/account_admin")
public class AccountAdminCtr {
	
	@Autowired
	private  AccountAdminService accountAdminService;
	
	
	
	
/*	public AccountAdminCtr(AccountAdminService aAs) {
		this.aAs = aAs;
	}*/
	
	@PostMapping("/register_new_account")
	public ResponseEntity<String> save(@RequestBody AccountAdmin ac) {
		
		try {
			accountAdminService.save(ac);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("nuovo ristorante registrato", HttpStatus.OK);
		
	}
	
	@PutMapping("/update_account")
	public ResponseEntity<String> update(@RequestBody AccountAdmin ac) {
		
		try {
			accountAdminService.save(ac);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("ristorante aggiornato", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete_all_accounts")
	public ResponseEntity<String> deleteAll(@RequestBody AccountAdmin ac) {
		
		try {
			accountAdminService.deleteAll(ac);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("ellimina tutti gli account creati", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete_account")
	public ResponseEntity<String> delete(@RequestBody AccountAdmin ac) {
		
		try {
			accountAdminService.delete(ac);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("ellimina  account creato", HttpStatus.OK);
		
	}
	
	@PostMapping("/confirm")
    public ResponseEntity<String> confirmEmailAndPassword(@RequestBody AccountAdmin credentials) {
        boolean isValid = accountAdminService.checkEmailAndPassword(credentials.getEmailRistorante(), credentials.getPasswordRistorante());

        if (isValid) {
            return ResponseEntity.ok("Email and password confirmed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
	}

}
