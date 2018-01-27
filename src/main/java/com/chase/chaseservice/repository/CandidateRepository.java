package com.chase.chaseservice.repository;


import com.chase.chaseservice.domain.CandidateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateRepository extends CrudRepository<CandidateEntity,Long> {
    List<CandidateEntity> getAllByCandidateIdCardLikeAndCandidateNameLikeAndCandidateSurNameLike(String idCard, String name , String surName);
}
