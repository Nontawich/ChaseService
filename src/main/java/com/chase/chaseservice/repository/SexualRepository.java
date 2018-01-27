package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.MsSexualEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SexualRepository  extends CrudRepository<MsSexualEntity,Long> {
    List<MsSexualEntity> getAllByStatusEqualsOrderBySexualIdAsc(String status);
}
