package pt.sali.SALI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.model.Role;
import pt.sali.SALI.service.IRole;

@RestController
@RequestMapping("/Role")
public class HCRole {
	
	@Autowired
	IRole iRole;
	
	@PostMapping("/add")
	public String addRole (@RequestBody Role r) {
		
		iRole.save(r);
		return "";
	}
	
	public ResponseEntity<List<Role>> listarAllRoles (){
		
		return new ResponseEntity<List<Role>>(iRole.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Role> updateRole(@RequestBody Role r){
		iRole.save(r);
		return new ResponseEntity<Role>(r, HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<Role> deleteUsers(@RequestBody Role r){
		iRole.delete(r);
		return new ResponseEntity<Role>(r, HttpStatus.OK);
	}
}