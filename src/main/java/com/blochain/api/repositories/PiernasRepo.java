package com.blochain.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.blochain.api.models.nft.Brazo;
import com.blochain.api.models.nft.Piernas;

@Repository
public interface PiernasRepo extends CrudRepository<Piernas, Long> {

}
