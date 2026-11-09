package com.tka.dao;

import java.util.List;
import com.tka.entity.Laptop;

public interface LaptopDAO {

    public void insertLaptop(Laptop laptop);

    public List<Laptop> searchLaptopByBrand(String brand);

    public List<Laptop> searchLaptopAbovePrice(Double price);

    public List<Laptop> searchLaptopUnderPrice(Double price);

    public List<Laptop> searchLaptopByBrandNotEqual(String brand);

    public List<Laptop> searchLaptopPrice(Double price);

    public List<Laptop> searchLaptopByBrandName(List<String> brands);

    public List<Laptop> searchLaptopByPriceNotInRange(double min, double max);

    public List<Laptop> searchLaptopByPriceNotInRangeList(List<Double> prices);

    public List<Laptop> searchLaptopByBrandAndPrice(String brand, double price);

    public List<Laptop> searchLaptopNameStartWith(String name);

    public List<Laptop> getLaptopListByPrice(double price);

    public List<Laptop> getLaptopList();

    public Laptop getHighestPriceLaptop();

    public Laptop getLowestPriceLaptop();

    public Laptop getSecondHighestPriceLaptop();

    public Laptop getSecondLowestPriceLaptop();
}