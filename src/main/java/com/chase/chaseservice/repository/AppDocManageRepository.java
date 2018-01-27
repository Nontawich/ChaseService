package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.ChaseDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppDocManageRepository extends JpaRepository<ChaseDocument, Long>{
    List<ChaseDocument> findByOwner(String owner);

    @Procedure(name = "GET_FILE_ID")
    String fnGetFileId(@Param("in_reg_id") String in_reg_id);

    @Procedure(name = "GET_FILE_ID_BY_STATE")
    String fnGetFileIdByState(@Param("in_reg_id") String in_reg_id);
}
