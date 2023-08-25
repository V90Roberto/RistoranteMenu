package com.menuristorante.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.menuristorante.project.model.Menu;
import com.menuristorante.project.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuCtr {
	
	private final MenuService menuService;
	
	@Autowired
	public MenuCtr(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@PostMapping("/create_menu")
	public ResponseEntity<String> saveMenu(@RequestBody Menu mu) {
		
		try {
			menuService.saveMenu(mu);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("nuovo menu registrato", HttpStatus.OK);
		
	}
	
	@PutMapping("/update_menu")
	public ResponseEntity<String> updateMenu(@RequestBody Menu mu) {
		
		try {
			menuService.saveMenu(mu);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("aggiornato il menu", HttpStatus.OK);
		
	}
	
	@PatchMapping("/update_menu_description")
	public ResponseEntity<String> updateDescription(@RequestBody Menu mu) throws NotFoundException  {
		
		menuService.updateDescription(mu);
		return new ResponseEntity<>("modifica effettuata", HttpStatus.OK);
		
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Menu>> findAll() {
		
		try {
			menuService.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Menu>>(menuService.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/findByType")
	public ResponseEntity<List<Menu>> findByType(@RequestParam String type) {
		
		try {
			menuService.findByType(type);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Menu>>(menuService.findByType(type), HttpStatus.OK);
		
	}

}
