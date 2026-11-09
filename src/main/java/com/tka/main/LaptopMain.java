package com.tka.main;

import java.util.List;
import java.util.Arrays;

import com.tka.dao.LaptopDAO;
import com.tka.daoImpl.LaptopDaoImpl;
import com.tka.entity.Laptop;

public class LaptopMain {

    public static void main(String[] args) {

        LaptopDAO laptopdao = new LaptopDaoImpl();

        List<Laptop> laptop_list;

        /*
        laptop_list = laptopdao.searchLaptopByBrand("HP");
        laptop_list.forEach(l -> System.out.println(l));

        laptop_list = laptopdao.searchLaptopAbovePrice(50000.0);
        laptop_list.forEach(l -> System.out.println(l));

        laptop_list = laptopdao.searchLaptopUnderPrice(80000.0);
        laptop_list.forEach(l -> System.out.println(l));

        laptop_list = laptopdao.searchLaptopByBrandNotEqual("Dell");
        laptop_list.forEach(l -> System.out.println(l));

        laptop_list = laptopdao.searchLaptopPrice(50000.0);
        laptop_list.forEach(l -> System.out.println(l));

        List<String> brands = Arrays.asList("HP", "Dell", "Lenovo");
        laptop_list = laptopdao.searchLaptopByBrandName(brands);
        laptop_list.forEach(l -> System.out.println(l));

        laptop_list = laptopdao.searchLaptopByBrandAndPrice("HP", 50000);
        laptop_list.forEach(l -> System.out.println(l));

        laptop_list = laptopdao.searchLaptopNameStartWith("Idea");
        laptop_list.forEach(l -> System.out.println(l));

        laptop_list = laptopdao.getLaptopListByPrice(50000);
        laptop_list.forEach(l -> System.out.println(l));

        laptop_list = laptopdao.getLaptopList();
        laptop_list.forEach(l -> System.out.println(l));
        */

        System.out.println("Highest Price Laptop: " + laptopdao.getHighestPriceLaptop());
        System.out.println("Lowest Price Laptop: " + laptopdao.getLowestPriceLaptop());
        System.out.println("Second Highest Price Laptop: " + laptopdao.getSecondHighestPriceLaptop());
        System.out.println("Second Lowest Price Laptop: " + laptopdao.getSecondLowestPriceLaptop());
    }
}