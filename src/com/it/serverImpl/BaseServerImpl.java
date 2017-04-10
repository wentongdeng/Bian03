package com.it.serverImpl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.it.server.BaseServer;

public class BaseServerImpl<T> implements BaseServer<T> {

	
	private SessionFactory sessionFactory;
	private Class clazz; 

	public BaseServerImpl() {
		System.out.println("this������ǵ�ǰ���ù��췽���Ķ���" + this);
		System.out.println("��ȡ��ǰthis����ĸ�����Ϣ" + this.getClass().getSuperclass());
		System.out.println("��ȡ��ǰthis����ĸ�����Ϣ(����������Ϣ)" + this.getClass().getGenericSuperclass());
		//�õ����͵Ĳ�������
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);

	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);	

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println(clazz.getSimpleName());
		String hql = "delete " + clazz.getSimpleName() + " as c where c.id=:id";
		getSession().createQuery(hql) //
				  .setInteger("id", id) //
				  .executeUpdate();
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		String hql = "from " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

}
