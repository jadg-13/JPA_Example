package repository.dao;

import entities.Carrera;
import jakarta.persistence.EntityManager;
import repository.ICarrera;

import java.util.List;

public class CarreraDao implements ICarrera {
    private final EntityManager em;

    public CarreraDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Carrera guardar(Carrera carrera) {
        if (carrera.getId() == null) {
            em.getTransaction().begin();
            em.persist(carrera);
            em.getTransaction().commit();
            return carrera;
        }
        return em.merge(carrera);
    }

    @Override
    public List<Carrera> listar() {
        List<Carrera> lista = em.createQuery("from Carrera", Carrera.class).getResultList();
        return lista;
    }
}
