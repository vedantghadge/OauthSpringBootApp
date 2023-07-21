package com.example;

import com.example.model.Employee;
import com.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringbootoauthexApplication {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootoauthexApplication.class, args);
    }


    @PostConstruct
    public void saveData() {
        Employee employee= new Employee(1010, "suraj", 500000);

        employeeRepoImpl.save(employee);

    }


}
