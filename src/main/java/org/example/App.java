package org.example;

import com.sun.net.httpserver.HttpServer;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class App
{
    static ArrayList<Product> products = new ArrayList<>();
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buildProductList();
        //server.createContext("/applications/myapp", new MyHandler());
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static void buildProductList() {
        Product.add(new Product(36213,"Huawei Honor 8 BLACK",25.94, 6));
        Product.add(new Product(36214,"Huawei Honor 8 RED",26.94, 1));
        Product.add(new Product(36215,"Apple IPhone 13 RED",1226.94, 10));
        Gson gson = new Gson();
        System.out.println(gson.toJson(products));
    }

    public static ArrayList<Product> getProducts() {
    }
}