package com.chase.chaseservice.services.interfaces;

import com.chase.chaseservice.dto.ChaseDocumentDto;
import com.chase.chaseservice.domain.ChaseDocument;

import java.util.List;

public interface DocumentManagementService {
    ChaseDocument add(ChaseDocument acfsDocument);
    ChaseDocument findById(Long id);
    ChaseDocument deleteFile(ChaseDocument acfsDocument);
    List<ChaseDocumentDto> findByOwner(String owner);
    String getFileId(String owner);
    String getFileIdByState(String owner);
}
