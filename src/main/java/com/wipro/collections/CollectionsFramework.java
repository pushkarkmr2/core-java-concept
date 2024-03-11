package com.wipro.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CollectionsFramework {
    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(CollectionsFramework.class);

        List<Integer> list = Arrays.asList(5,3,8,1,9,2,4,7,6);

        // sorting using lambdas
        List<Integer> sortedList = list.stream().sorted(Comparator.reverseOrder()).toList();
        log.info("Sorted List : {}" , sortedList);
        // filtering using lambdas
        List<Integer> evenList = list.stream().filter(x -> x%2==0).toList();
        log.info("Even List : {}" , evenList);
        // mapping to squares
        List<Integer> squaresList = list.stream().map(x -> x*x).toList();
        log.info("Squares List : {}" , squaresList);
        // Creating a hashmap with numbers as keys and squares as its values
        HashMap<Integer,Integer> numSquareMap = list.stream().collect(HashMap::new, (map,x) -> map.put(x, x*x), HashMap::putAll);
        log.info("Number-Square Map : {}",numSquareMap);

        log.info("--------------------------------------------------");
        // printing same map with foreach loop
        numSquareMap.forEach((key, value) -> log.info("key= {} , value = {}" , key , value));
        log.info("--------------------------------------------------");

        List<HashMap<String,Integer>> productList = new CollectionsFramework().getProductList();

        List<String> studentList= productList.stream().flatMap(map -> map.keySet().stream()).distinct().sorted().toList();

        Map<String,Integer> productMap = new HashMap<>();
        studentList.forEach(x-> productList.forEach(map -> {
            if(map.containsKey(x)) {
                if (productMap.containsKey(x))
                    productMap.put(x, productMap.get(x) + map.get(x));
                else
                    productMap.put(x, map.get(x));
            }
        }));

        log.info("Product MAP : {}" , productMap );


    }


    public List<HashMap<String,Integer>> getProductList(){

        HashMap<String,Integer> productMap = new HashMap<>();
        productMap.put("Item1",34);
        productMap.put("Item2",67);
        productMap.put("Item3",24);
        productMap.put("Item4",56);
        productMap.put("Item5",78);

        HashMap<String,Integer> productMap2 = new HashMap<>();
        productMap2.put("Item1",12);
        productMap2.put("Item2",98);
        productMap2.put("Item3",77);
        productMap2.put("Item4",34);
        productMap2.put("Item6",90);

        List<HashMap<String,Integer>> productList = new ArrayList<>();
        productList.add(productMap);
        productList.add(productMap2);

        return productList;
    }
}
