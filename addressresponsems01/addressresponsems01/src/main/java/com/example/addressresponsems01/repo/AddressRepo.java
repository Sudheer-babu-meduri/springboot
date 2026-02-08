package com.example.addressresponsems01.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.addressresponsems01.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{


	
	@Query(nativeQuery = true,
		       value = "SELECT sa.id, sa.fno, sa.street, sa.city, sa.state, sa.pincode, sa.student_id " +
		               "FROM address1 sa " +
		               "JOIN student2 s ON s.sid = sa.student_id " +
		               "WHERE sa.student_id = :sid")
		Optional<Address> findAddressByStudentId(@Param("sid") int sid);

}