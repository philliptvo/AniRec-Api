package org.ani7.anirec.controllers;

import org.ani7.anirec.models.Upvotes;
import org.ani7.anirec.payloads.ApiResponse;
import org.ani7.anirec.services.UpvotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/upvotes")
public class UpvotesController {

  @Autowired
  private UpvotesService service;

  @GetMapping("")
  public List<Upvotes> getAllSnippets(@RequestParam(defaultValue = "1") String pageNum,
                                      @RequestParam(defaultValue = "25") String pageSize) {
    Page<Upvotes> page = service.findAllUpvotes(Integer.parseInt(pageNum) - 1,
                                                Integer.parseInt(pageSize));
    return page.getContent();
  }

  @GetMapping("{id}")
  public ResponseEntity<Upvotes> getUpvotesById(@PathVariable Integer id) {
    try {
      Upvotes upvote = service.getUpvoteById(id);
      return new ResponseEntity<>(upvote, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("")
  public ResponseEntity<Upvotes> createUpvote(@RequestBody Upvotes upvote) {
    service.saveUpvote(upvote);
    return new ResponseEntity<>(upvote, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Upvotes> updateUpvote(@RequestBody Upvotes upvote, @PathVariable Integer id) {
    try {
      Upvotes oldUpvotes = service.getUpvoteById(id);
      upvote.setUpvoteId(id);
      service.saveUpvote(upvote);
      return new ResponseEntity<>(upvote, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteSnippet(@PathVariable Integer id) {
    try {
      service.deleteUpvoteById(id);
      return new ResponseEntity<>(new ApiResponse(true, "Snippets deleted successfully"),
                                  HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
