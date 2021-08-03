package org.ani7.anirec.controllers;

import org.ani7.anirec.models.Characters;
import org.ani7.anirec.payloads.ApiResponse;
import org.ani7.anirec.services.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/characters")
public class CharactersController {

    @Autowired
    private CharactersService service;

    @GetMapping("")
    public List<Characters> getAllCharacters(@RequestParam(defaultValue = "1") String pageNum,
                                        @RequestParam(defaultValue = "25") String pageSize) {
        Page<Characters> page = service.findAllCharacters(Integer.parseInt(pageNum) - 1,
                Integer.parseInt(pageSize));
        return page.getContent();
    }

    @GetMapping("{id}")
    public ResponseEntity<Characters> getCharacterById(@PathVariable Integer id) {
        try {
            Characters character = service.getCharactersById(id);
            return new ResponseEntity<>(character, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{characterName}")
    public ResponseEntity<Characters> getCharactersByName(@PathVariable String cName) {
        try {
            Characters character = service.getCharactersByName(cName).orElseThrow(() -> new NoSuchElementException());
            return new ResponseEntity<>(character, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Characters> createCharacter(@RequestBody Characters character) {
        service.saveCharacter(character);
        return new ResponseEntity<>(character, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Characters> updateCharacter(@RequestBody Characters character, @PathVariable Integer id) {
        try {
            Characters oldCharacter = service.getCharactersById(id);
            character.setCharacterId(id);
            service.saveCharacter(character);
            return new ResponseEntity<>(character, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable Integer id) {
        try {
            service.deleteCharactersById(id);
            return new ResponseEntity<>(new ApiResponse(true, "Character deleted successfully"), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
