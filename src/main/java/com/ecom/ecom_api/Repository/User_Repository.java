package com.ecom.ecom_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.ecom_api.Objects.Models.User;

@Repository
public interface User_Repository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User find_by_email_address(String emailAddress);

    // User findByFirstNameAndLastName(String firstName, String lastName);
}
