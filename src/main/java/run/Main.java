package run;

import config.JPAUtil;
import entities.Carrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.dao.CarreraDao;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        Carrera carrera = new Carrera();
        carrera.setNombre("Ingenieria en Sistemas xyz");
        carrera.setPrecio(250);

        CarreraDao dao = new CarreraDao(em);

        System.out.println(dao.guardar(carrera));

        List<Carrera> carreras = dao.listar();
        for (Carrera c : carreras) {
            System.out.println(c);
        }


    }
}
