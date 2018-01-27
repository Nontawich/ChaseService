package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.MsSubDistrictEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubDistrictRepository extends CrudRepository<MsSubDistrictEntity,Long> {

    List<MsSubDistrictEntity> getAllByDistrictIdEqualsOrderBySubDistrictName(Integer districtId);
}
