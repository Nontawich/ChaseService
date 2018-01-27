package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.MsDistrictEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DistrictRepository extends CrudRepository<MsDistrictEntity,Long> {

    List<MsDistrictEntity> getAllByStatusEqualsAndProvinceIdEqualsOrderByDistrictName(String status, Integer provinceId);
}
