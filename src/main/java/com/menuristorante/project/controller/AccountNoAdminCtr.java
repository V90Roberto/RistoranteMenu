package com.menuristorante.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menuristorante.project.model.AccountAdmin;
import com.menuristorante.project.service.AccountAdminService;

@RestController
@RequestMapping("/account")
public class AccountNoAdminCtr {
	
	@Autowired
	private  AccountAdminService accountAdminService;
	
	@PostMapping("/create_account")
    public ResponseEntity<String> createNonAdminAccount(@RequestBody AccountAdmin admin, @RequestBody AccountAdmin nonAdmin) {
        try {
            accountAdminService.createNonAdminAccount(admin, nonAdmin);
            return ResponseEntity.ok("Account non amministratore creato.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

}
