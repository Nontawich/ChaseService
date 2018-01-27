package com.chase.chaseservice.services.interfaces;

import com.chase.chaseservice.dto.DistrictDto;
import com.chase.chaseservice.dto.ModuleDto;
import com.chase.chaseservice.dto.RegisterPageDto;
import com.chase.chaseservice.dto.SubDistrictDto;

import java.util.List;

public interface MasterService {
    List<ModuleDto> getMenu(String personType,String locale);
    RegisterPageDto getRegisterPage(String locale);
    List<SubDistrictDto> getSubDistrictByDistrict(String districtId);
     List<DistrictDto> getDistrictByProvince(String provinceId);
}
