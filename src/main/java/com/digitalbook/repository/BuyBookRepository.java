package com.digitalbook.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitalbook.entity.BuyBook;

@Repository
public interface BuyBookRepository extends CrudRepository<BuyBook, Integer> {
	
	List<BuyBook> findByUserId(Long id);

}
