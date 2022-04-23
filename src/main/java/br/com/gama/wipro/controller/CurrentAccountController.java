package br.com.gama.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.entities.dto.CurrentDto;
import br.com.gama.wipro.services.CurrentAccountService;

@RequestMapping("/current")
@RestController
public class CurrentAccountController {

	private CurrentAccountService service;

	@Autowired
	public CurrentAccountController(CurrentAccountService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<CurrentAccount>> findAll() {
		List<CurrentAccount> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CurrentAccount> findById(@PathVariable Integer id) {
		CurrentAccount response = service.findById(id);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping
	public ResponseEntity<CurrentAccount> insert(@RequestBody CurrentDto obj) {
		CurrentAccount newObj = service.create(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(newObj);
	}
}