package com.chase.chaseservice.repository;


import com.chase.chaseservice.domain.RegisteDetailEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegisterDetailRepository extends CrudRepository<RegisteDetailEntity,Long> {
    RegisteDetailEntity getFirstByCandidateIdEquals(Integer id);

}
