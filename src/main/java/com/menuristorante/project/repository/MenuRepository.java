package com.menuristorante.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menuristorante.project.model.Menu;


@Repository
public interface MenuRepository extends JpaRepository <Menu, Long> {
	
	List<Menu> findByType(String type);

	

	
	
	

}
