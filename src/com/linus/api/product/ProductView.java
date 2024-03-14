package com.linus.api.product;

import com.linus.api.common.UtilService;
import com.linus.api.common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();
        for (int i = 0; i < 4; i++) {
            products.add(Product.builder()
                    .i(sc.nextInt())
                    .name(sc.next())
                    .company(util.createRandomCompany())
                    .price(sc.nextInt())
                    .build());
        }


        products.forEach(i -> {
            System.out.println(i.toString());
        });


    }
}
