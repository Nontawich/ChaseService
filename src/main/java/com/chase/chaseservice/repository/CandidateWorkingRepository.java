package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.CandidateWorkEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateWorkingRepository  extends CrudRepository<CandidateWorkEntity,Long> {

    List<CandidateWorkEntity> getAllByCandidateIdEqualsOrderByJobStartAsc(Integer candidateId);
}
