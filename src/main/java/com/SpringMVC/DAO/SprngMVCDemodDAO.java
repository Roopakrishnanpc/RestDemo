package com.SpringMVC.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SpringMVC.model.SprngMVCDemo;

@Component
public class SprngMVCDemodDAO {
	@Autowired
	private SessionFactory sessionFactory;
	//finall
	@Transactional
public List<SprngMVCDemo> getModels()
{
	Session session=sessionFactory.getCurrentSession();
	List<SprngMVCDemo> sprngMVCDemo =session.createQuery("from SprngMVCDemo",SprngMVCDemo.class).list();
	return sprngMVCDemo;
}
	//add or insert
@Transactional
	public void addModelAnother(SprngMVCDemo sprngMVCDemo) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(sprngMVCDemo);
	}
//select for id
@Transactional
public SprngMVCDemo getMod(int id) {
	// TODO Auto-generated method stub
	Session session=sessionFactory.getCurrentSession();
	SprngMVCDemo sSprngMVCDemo=session.get(SprngMVCDemo.class,id);
	return sSprngMVCDemo;
}
@Transactional
public void updateModel(int id, String newName) {
    Session session = sessionFactory.getCurrentSession();
        // Begin transaction
       // session.beginTransaction();
       // session
        // Fetch the entity
        SprngMVCDemo demo = session.get(SprngMVCDemo.class, id);
        if (demo != null) {
            // Modify the entity
            demo.setName(newName);
            session.update(demo);
        }
            // The entity is automatically updated in the database at the end of the transaction
        }

        // Commit transaction all not needed
       // session.getTransaction().commit(); 
@Transactional
public void deleteEntity(int id) {
    Session session = sessionFactory.getCurrentSession();
    SprngMVCDemo entity = session.get(SprngMVCDemo.class, id);
    if (entity != null) {
        session.delete(entity);
    }
}

@Transactional
public void deleteAllEntities() {
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("DELETE FROM SprngMVCDemo");
    query.executeUpdate();
}

}
