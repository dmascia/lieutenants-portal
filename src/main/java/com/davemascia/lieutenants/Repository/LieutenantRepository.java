package com.davemascia.lieutenants.Repository;

import com.davemascia.lieutenants.Model.Lieutenant;
import org.springframework.data.repository.CrudRepository;

public interface LieutenantRepository extends CrudRepository<Lieutenant, Integer> {
}
