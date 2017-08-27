package com.ak.learning.employee.v1.repositories;

import com.ak.learning.employee.models.v1.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findByName(String value) {
        return (List<Employee>) entityManager
                .createQuery("FROM Employee as emp WHERE emp.name = :name")
                .setParameter("name", value)
//                .setMaxResults()
                .getResultList();
    }

    @Override
    public Employee findById(long id) {
        return entityManager.find(Employee.class, id);
    }
}
