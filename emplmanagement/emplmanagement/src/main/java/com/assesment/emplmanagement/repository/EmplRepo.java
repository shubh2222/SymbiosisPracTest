package com.assesment.emplmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.emplmanagement.entity.Employee;

@Repository
public interface EmplRepo extends JpaRepository<Employee, Long>{

}
