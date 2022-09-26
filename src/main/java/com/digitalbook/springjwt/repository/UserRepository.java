package com.digitalbook.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalbook.springjwt.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query(value="SELECT u.id FROM booksdetailsdb.users u where u.username=:username and u.email=:useremail",nativeQuery = true)
	int getuserId(String username, String useremail);

	 User findByEmail(String emailId);
	}
