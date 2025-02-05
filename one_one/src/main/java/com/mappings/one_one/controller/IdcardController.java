package com.mappings.one_one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mappings.one_one.model.Idcard;
import com.mappings.one_one.service.IdcardService;

@RestController
@RequestMapping("/idcard")
public class IdcardController {
	
	@Autowired
	private IdcardService cardService;
	
	@PostMapping("/addcard")
	public ResponseEntity<Idcard> createIdcard(@RequestBody Idcard idcard) {
	    Idcard createdIdCard = cardService.createIdcard(idcard);
	    return ResponseEntity.ok(createdIdCard);
	}
	
	@GetMapping("/displaycard")
	public List<Idcard> getAllIdcards() {
        return cardService.getAllIdcards();
    }
	
	@GetMapping("/displaycard/{id}")
	public Idcard getIdcardById(@PathVariable Long id) {
        return cardService.getIdcardById(id);
    }
	
	@PutMapping("/updatecard/{id}")
    public ResponseEntity<Idcard> updateIdcard(@PathVariable Long id, @RequestBody Idcard updatedIdcard) {
        Idcard updatedCard = cardService.updateIdcard(id, updatedIdcard);
        return ResponseEntity.ok(updatedCard);
    }
	
	@DeleteMapping("/deletecard/{id}")
    public ResponseEntity<String> deleteIdcard(@PathVariable Long id) {
		try {
			cardService.deleteIdcard(id);
	        return ResponseEntity.ok("IdCard deleted successfully!");
		} catch(RuntimeException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
    }
}
