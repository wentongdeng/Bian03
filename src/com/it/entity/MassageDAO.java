package com.it.entity;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Massage entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.it.entity.Massage
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class MassageDAO {
	private static final Logger log = LoggerFactory.getLogger(MassageDAO.class);
	// property constants
	public static final String TEXT = "text";
	public static final String TITLE = "title";
	public static final String LIKE = "like";
	public static final String TIME = "time";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.openSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Massage transientInstance) {
		log.debug("saving Massage instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Massage persistentInstance) {
		log.debug("deleting Massage instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Massage findById(java.lang.Integer id) {
		log.debug("getting Massage instance with id: " + id);
		try {
			Massage instance = (Massage) getCurrentSession().get("com.it.entity.Massage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Massage instance) {
		log.debug("finding Massage instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.it.entity.Massage").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Massage instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Massage as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByLike(Object like) {
		return findByProperty(LIKE, like);
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findAll() {
		log.debug("finding all Massage instances");
		try {
			String queryString = "from Massage";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Massage merge(Massage detachedInstance) {
		log.debug("merging Massage instance");
		try {
			Massage result = (Massage) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Massage instance) {
		log.debug("attaching dirty Massage instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Massage instance) {
		log.debug("attaching clean Massage instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MassageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MassageDAO) ctx.getBean("MassageDAO");
	}
}