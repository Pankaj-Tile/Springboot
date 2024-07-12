package com.jpa_test.jpa_example.dao;
import com.jpa_test.jpa_example.entities.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;
public interface UserRepository extends CrudRepository<User,Integer> {

    public List<User> findByName(String name);
    public List<User> findByNameAndCity(String name,String city);
    //findBy LessThan/EqualTo.. 


    //jspl querys
    @Query("select u From User u ")  //hear User indicating User entities in package obtain by spring data jpa 
    public List<User>getAllUser();

    @Query("select u From User u Where u.name=:n")  //hear =: this notation is user for parameter so its a para meterize query and n is parameter so we have to map this n with our methods parameter 
    public List<User>getAllUserByName(@Param("n") String name);

    
    @Query("select u From User u Where u.name=:n and u.city=:c")  //hear =: this notation is user for parameter so its a para meterize query and n is parameter so we have to map this n with our methods parameter 
    public List<User>getAllUserByNameAndCity(@Param("n") String name,@Param("c") String city);


    //native query
    @Query(value = "select * from user",nativeQuery = true)
    public List <User> getUsers();
}

