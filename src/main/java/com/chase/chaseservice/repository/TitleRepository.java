package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.MsTitleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TitleRepository extends CrudRepository<MsTitleEntity,Long> {

    List<MsTitleEntity> getAllByStatusEqualsOrderByTitleId(String status);
}
