package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.RegisterListViewEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegisterListRepository extends CrudRepository<RegisterListViewEntity,Long> {
    List<RegisterListViewEntity> getAllByIdCardLikeAndCandidateFullNameLikeOrderByCandidateFullNameAsc(String idCard, String name);
}
