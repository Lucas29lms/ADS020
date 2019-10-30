/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Contato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author 18114290046
 */
public class ContatoDAO {

    public void persist(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinhaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(contato);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void merge(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinhaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(contato);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinhaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.merge(contato));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Contato find(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinhaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Contato contato = new Contato();
        try {
            contato = em.find(Contato.class, id);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return contato;
    }

    public List<Contato> list() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinhaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Contato> lista = new ArrayList<Contato>(); 
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contato.class));
            lista = em.createQuery(cq).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        
        return lista;
    }
}
