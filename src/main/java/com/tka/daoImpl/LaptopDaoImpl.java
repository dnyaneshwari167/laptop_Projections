package com.tka.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tka.dao.LaptopDAO;
import com.tka.entity.Laptop;

public class LaptopDaoImpl implements LaptopDAO {

    private Session getSession() {
        return new Configuration().configure()
                .buildSessionFactory().openSession();
    }

    public void insertLaptop(Laptop laptop) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        session.save(laptop);

        transaction.commit();
        session.close();
        System.out.println("Laptop Data Saved...");
    }

    public List<Laptop> searchLaptopByBrand(String brand) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.eq("brand", brand)).list();
        session.close();
        return list;
    }

    public List<Laptop> searchLaptopAbovePrice(Double price) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.gt("price", price)).list();
        session.close();
        return list;
    }

    public List<Laptop> searchLaptopUnderPrice(Double price) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.le("price", price)).list();
        session.close();
        return list;
    }

    public List<Laptop> searchLaptopByBrandNotEqual(String brand) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.ne("brand", brand)).list();
        session.close();
        return list;
    }

    public List<Laptop> searchLaptopPrice(Double price) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.ge("price", price)).list();
        session.close();
        return list;
    }

    public List<Laptop> searchLaptopByBrandName(List<String> brands) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.in("brand", brands)).list();
        session.close();
        return list;
    }

    public List<Laptop> searchLaptopByPriceNotInRange(double min, double max) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.not(Restrictions.between("price", min, max))).list();
        session.close();
        return list;
    }

    public List<Laptop> searchLaptopByPriceNotInRangeList(List<Double> prices) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.not(Restrictions.in("price", prices))).list();
        session.close();
        return list;
    }

    public List<Laptop> searchLaptopByBrandAndPrice(String brand, double price) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.and(
                        Restrictions.eq("brand", brand),
                        Restrictions.ge("price", price))).list();
        session.close();
        return list;
    }

    public List<Laptop> searchLaptopNameStartWith(String name) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.like("model", name + "%")).list();
        session.close();
        return list;
    }

    public List<Laptop> getLaptopListByPrice(double price) {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .add(Restrictions.ge("price", price))
                .addOrder(Order.asc("price")).list();
        session.close();
        return list;
    }

    public List<Laptop> getLaptopList() {
        Session session = getSession();
        List<Laptop> list = session.createCriteria(Laptop.class)
                .addOrder(Order.desc("price"))
                .setFirstResult(0).setMaxResults(5).list();
        session.close();
        return list;
    }

    public Laptop getHighestPriceLaptop() {
        Session session = getSession();
        Laptop laptop = (Laptop) session.createCriteria(Laptop.class)
                .addOrder(Order.desc("price"))
                .addOrder(Order.asc("id"))
                .setMaxResults(1).uniqueResult();
        session.close();
        return laptop;
    }

    public Laptop getLowestPriceLaptop() {
        Session session = getSession();
        Laptop laptop = (Laptop) session.createCriteria(Laptop.class)
                .addOrder(Order.asc("price"))
                .addOrder(Order.asc("id"))
                .setMaxResults(1).uniqueResult();
        session.close();
        return laptop;
    }

    public Laptop getSecondHighestPriceLaptop() {
        Session session = getSession();

        Double maxPrice = (Double) session.createCriteria(Laptop.class)
                .setProjection(Projections.max("price")).uniqueResult();

        Laptop laptop = null;

        if (maxPrice != null) {
            laptop = (Laptop) session.createCriteria(Laptop.class)
                    .add(Restrictions.lt("price", maxPrice))
                    .addOrder(Order.desc("price"))
                    .addOrder(Order.asc("id"))
                    .setMaxResults(1).uniqueResult();
        }

        session.close();
        return laptop;
    }

    public Laptop getSecondLowestPriceLaptop() {
        Session session = getSession();

        Double minPrice = (Double) session.createCriteria(Laptop.class)
                .setProjection(Projections.min("price")).uniqueResult();

        Laptop laptop = null;

        if (minPrice != null) {
            laptop = (Laptop) session.createCriteria(Laptop.class)
                    .add(Restrictions.gt("price", minPrice))
                    .addOrder(Order.asc("price"))
                    .addOrder(Order.asc("id"))
                    .setMaxResults(1).uniqueResult();
        }

        session.close();
        return laptop;
    }
}