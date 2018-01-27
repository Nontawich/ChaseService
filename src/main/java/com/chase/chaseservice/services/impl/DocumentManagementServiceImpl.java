package com.chase.chaseservice.services.impl;

import com.chase.chaseservice.dto.ChaseDocumentDto;
import com.chase.chaseservice.domain.ChaseDocument;
import com.chase.chaseservice.repository.AppDocManageRepository;
import com.chase.chaseservice.services.interfaces.DocumentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentManagementServiceImpl implements DocumentManagementService {

    @Autowired
    AppDocManageRepository docRepository;

    @Override
    public ChaseDocument add(ChaseDocument acfsDocument) {
        acfsDocument = docRepository.save(acfsDocument);
        return acfsDocument;
    }

    @Override
    public ChaseDocument findById(Long id) {
        ChaseDocument dslUsers = docRepository.findOne(Long.valueOf(id));
        return dslUsers;
    }

    @Override
    public ChaseDocument deleteFile(ChaseDocument acfsDocument) {
        acfsDocument.setStatus("I");
        acfsDocument = docRepository.save(acfsDocument);
        return acfsDocument;
    }

    @Override
    public List<ChaseDocumentDto> findByOwner(String owner) {
        List<ChaseDocumentDto> acfsDocDto= new ArrayList<>();
        List<ChaseDocument> dslUsers = docRepository.findByOwner(owner);
        return acfsDocDto;
    }

    @Override
    public String getFileId(String owner) {
        return docRepository.fnGetFileId(owner);
    }

    @Override
    public String getFileIdByState(String owner) {
        // TODO Auto-generated method stub
        return docRepository.fnGetFileIdByState(owner);
    }
}
