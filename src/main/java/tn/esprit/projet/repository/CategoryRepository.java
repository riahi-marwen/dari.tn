package tn.esprit.projet.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.projet.modal.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
