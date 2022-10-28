package edu.ucsb.cs156.example.controllers;

import edu.ucsb.cs156.example.entities.UCSBDiningCommons;
import edu.ucsb.cs156.example.entities.UCSBDiningCommonsMenuItem;
import edu.ucsb.cs156.example.errors.EntityNotFoundException;
import edu.ucsb.cs156.example.repositories.UCSBDiningCommonsMenuItemRepository;
import edu.ucsb.cs156.example.repositories.UCSBDiningCommonsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(description= "UCSBDiningCommonsMenuItem")
@RequestMapping("/api/ucsbdingingcommonsmenuitem")
@RestController
@Slf4j
public class UCSBDiningCommonsMenuItemController {
	
	@Autowired
	UCSBDiningCommonsMenuItemRepository ucsbDiningCommonsMenuItemRepository;

	@ApiOperation(value = "List all ucsb dining commons menu items")
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/all")
	public Iterable<UCSBDiningCommonsMenuItem> allMenuItems() {
		Iterable<UCSBDiningCommonsMenuItem> menuItems = ucsbDiningCommonsMenuItemRepository.findAll();
		return menuItems;
	}

	@ApiOperation(value = "Get a single dining commons menu item")
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("")
	public UCSBDiningCommonsMenuItem getById( @ApiParam("code") @RequestParam Long id) {
		UCSBDiningCommonsMenuItem menuItem = ucsbDiningCommonsMenuItemRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(UCSBDiningCommonsMenuItem.class, id));
		
		return menuItem;
	}

}

/*
 * private long id;

	private String diningCommonsCode;
	private String name;
	private String station;
 */