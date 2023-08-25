package com.menuristorante.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuristorante.project.model.Menu;
import com.menuristorante.project.repository.MenuRepository;

@Service
public class MenuService {
	
	private final MenuRepository menuRepository;
	
	@Autowired
	public MenuService(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}
	
	public void saveMenu(Menu mu) {
		menuRepository.save(mu);
	}
	
	public void updateMenu(Menu mu) {
		
		if(mu.getId() != null) {
			menuRepository.save(mu);
		}
	}
	
	public List<Menu> findAll(){
		
		return menuRepository.findAll();
		
	}
	
	public List<Menu> findByType(String type) {
		
		return menuRepository.findByType(type);
		
	}
	
	public void updateDescription(Menu mu) {
		
		
		if(mu.getId() != null) {
		   menuRepository.save(mu);
		}
		
		
	}

	
	

}
