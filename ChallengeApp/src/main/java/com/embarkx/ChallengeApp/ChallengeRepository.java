package com.embarkx.ChallengeApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


//CRUD
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {


}
