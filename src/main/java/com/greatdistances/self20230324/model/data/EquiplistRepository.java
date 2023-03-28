package com.greatdistances.self20230324.model.data;

import com.greatdistances.self20230324.model.Equiplist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquiplistRepository extends CrudRepository<Equiplist, Integer> {
}