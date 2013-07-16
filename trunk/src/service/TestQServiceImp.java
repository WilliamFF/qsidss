package service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.TestQ;

public class TestQServiceImp implements TestQService{
	
	private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unused")
	private EntityManager getEntityManager() {
        return em;
    }

	@Override
	public void save(TestQ tq) {
		 if (tq.getName() == null) {
	            // new
	            em.persist(tq);
	        } else {
	            // update
	            em.merge(tq);
	        }
		
	}

	@Override
	public void remove(String name) {
		TestQ tq = find(name);
        if (tq != null) {
            em.remove(tq);
        }		
	}

	@Override
	public TestQ find(String name) {
		 return em.find(TestQ.class, name);
	}
	


}
