package pt.sali.SALI.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Sintoma;

public interface ISintoma extends MongoRepository<Sintoma, String> {

}
