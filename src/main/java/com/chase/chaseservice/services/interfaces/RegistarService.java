package com.chase.chaseservice.services.interfaces;


import com.chase.chaseservice.dto.CandidateDetailDto;
import com.chase.chaseservice.dto.CandidateListDto;
import com.chase.chaseservice.dto.RegisterDto;


import java.util.List;
import java.util.Map;

public interface RegistarService {
    Integer saveRequestForm(RegisterDto registerDto);
    List<CandidateListDto> getRegisterList(Map<String, Object> payload );
    CandidateDetailDto getCandidateDetail(Map<String, Object> payload );
}
