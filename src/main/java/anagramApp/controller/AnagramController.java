package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.model.Request;
import org.example.model.Result;
import org.example.service.AnagramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/anagram")
public class AnagramController {

    private final AnagramService anagramService;

    @GetMapping("/check")
    public ResponseEntity<Result> check(@RequestBody Request request) {
        return new ResponseEntity<>(anagramService.checkStringsAreAnagram(request), HttpStatus.OK);
    }

}
