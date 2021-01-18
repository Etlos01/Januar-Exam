/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CategoryDTO;
import entities.Category;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nyxis
 */
public class CategoryFacade {

    private static CategoryFacade instance;
    private static EntityManagerFactory emf;

    private CategoryFacade() {

    }

    public static CategoryFacade getCategoryFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CategoryFacade();
        }
        return instance;
    }

    public CategoryDTO getCategories() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Category> q = em.createQuery("SELECT c FROM Category c", Category.class);
            return new CategoryDTO(q.getResultList());
        } finally {
            em.close();
        }
    }

}
