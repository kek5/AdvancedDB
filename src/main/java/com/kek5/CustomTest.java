package com.kek5;

import com.lits.kundera.test.BaseTest;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Assert;

public class CustomTest extends BaseTest{

    @Override
    public void customTest() throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hbase_pu");
        EntityManager em = emf.createEntityManager();

        Query findQuery = em.createQuery("select p from Physician p");
        List<com.kek5.Physician> allPhysicians = findQuery.getResultList();
        Assert.assertNotEquals(0, allPhysicians.size());

        Query findQuery2 = em.createQuery("select p from Patient p where p.firstName = \'Patient1\'");
        List<com.kek5.Patient> patients1 = findQuery2.getResultList();
        Assert.assertNotEquals(0, patients1.size());

        Query findQuery3 = em.createQuery("select mr from MedicalRecord mr where mr.type = \'type2\'");
        List<com.kek5.MedicalRecord> allRecords2 = findQuery3.getResultList();
        Assert.assertNotEquals(0, allRecords2.size());
    }
}
