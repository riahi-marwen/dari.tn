package tn.esprit.projet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.projet.modal.UploadFile;

@Repository
public interface UploadFileRepository extends CrudRepository<UploadFile, Long> {

}
