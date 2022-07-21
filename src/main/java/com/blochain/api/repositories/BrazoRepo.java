package com.blochain.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.blochain.api.models.nft.Brazo;

@Repository
public interface BrazoRepo extends CrudRepository<Brazo, Long> {

}
