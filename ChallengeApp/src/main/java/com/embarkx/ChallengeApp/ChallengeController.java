package com.embarkx.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;

    }

    @GetMapping
    public List<Challenge> getChallengeList() {
        return challengeService.getAllChallenges();
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if(isChallengeAdded)
            return new ResponseEntity<>("Challenge Added successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge Not Added successfully",HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(
            @PathVariable String month) {
        Challenge challenge =  challengeService.getChallenge(month);
        if (challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedChallenge);
        if (isChallengeUpdated)
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not updated successfully",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if (isChallengeDeleted)
            return new ResponseEntity<>("Challenge Deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not deleted successfully",HttpStatus.NOT_FOUND);

    }

}
