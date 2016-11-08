/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidad.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Wilver
 */
public class ClienteDao {
    public void insertar(Cliente clie){
    SessionFactory sf=null;
    Session session=null;
    Transaction tx=null;
        try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            tx=session.beginTransaction();
            session.save(clie);
            tx.commit();
            session.close();
        } catch (Exception e) {
            tx.rollback();
            throw  new RuntimeException("no se puede guardar cliente");
        }
}
    public String consultarCliente(int id){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        Cliente clie=(Cliente) session.get(Cliente.class, id);
        session.close();
        if (clie!=null) {
            return "el codigo del cliente es"+clie.getIdcliente()+ " el cliente es "+clie.getNombre();
        }else{
            return id+" el producto no existe";
        }
    }
    public List<Cliente> verClientes(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        Query query=session.createQuery("from cliente");
        List<Cliente>lista=query.list();
        session.close();
        return  lista;   
    }
}
