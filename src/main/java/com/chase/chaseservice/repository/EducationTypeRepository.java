package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.MsEducationTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EducationTypeRepository extends CrudRepository<MsEducationTypeEntity,Long> {

    List<MsEducationTypeEntity> getAllByStatusEqualsOrderBySeqAsc(String status);
}
