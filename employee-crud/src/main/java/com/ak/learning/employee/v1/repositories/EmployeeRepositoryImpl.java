package com.ak.learning.employee.v1.repositories;

import com.ak.learning.employee.v1.models.dto.EmployeeDTO;
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
    public List<EmployeeDTO> findByName(String value) {
        return (List<EmployeeDTO>) entityManager
                .createQuery("FROM EmployeeDTO as emp WHERE emp.name = :name")
                .setParameter("name", value)
//                .setMaxResults()
                .getResultList();
    }

    @Override
    public EmployeeDTO findById(long id) {
        return entityManager.find(EmployeeDTO.class, id);
    }
}
