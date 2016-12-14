package com.kek5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyTest {
    public static void main(String[] args) {
        MedicalRecord record = new MedicalRecord();

        record.setId("thisisrecord".getBytes());
        record.setDatePerformed(new Date(1999, 01, 01));
        record.setDescription("description");
        record.setType("type");

        Map<String, String> properties = new HashMap<>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hbase_pu", properties);
        EntityManager manager = factory.createEntityManager();

        manager.persist(record);

        manager.close();
        manager.close();
    }
}
