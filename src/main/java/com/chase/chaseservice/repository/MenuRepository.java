package com.chase.chaseservice.repository;

import com.chase.chaseservice.domain.MsModuleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<MsModuleEntity,Long> {

    @Query(value = " select bm.module_id as module_id, bm.module_code as module_code,  CASE WHEN ?2 = 'EN' THEN  bm.module_name_en ELSE bm.module_name_th END  " +
            " as module_name,\n" +
            " bm.is_active as module_active, bmm.menu_id as menu_id, bmm.menu_code as menu_code,\n" +
            " CASE WHEN ?2 = 'EN' THEN bmm.menu_name_en ELSE bmm.menu_name_th END  as menu_name,bmm.is_active as menu_active , bm.module_path as module_path , \n" +
            " bmm.menu_path as menu_path \n , bm.module_icon as moduleicon " +
            " from \"ms_module\" bm left join \"ms_menu\" bmm on bm.module_id = bmm.module_id\n" +
            " where bm.status = 'Y' and ( bmm.status = 'Y' or bmm.status is null)and bm.module_type = ?1 \n" +
            " order by bm.module_seq asc , bmm.menu_seq asc", nativeQuery = true)
    List<Object[]> getMenu(Integer persontypeId, String locale);
}
