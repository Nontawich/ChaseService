package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.MsProvinceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProvinceRepository extends CrudRepository<MsProvinceEntity,Long> {
    List<MsProvinceEntity> getAllByStatusEqualsOrderByProvinceNameAsc(String status);
}
