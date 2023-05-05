package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {

        return x -> {
          return x.stream().allMatch(s -> !x.isEmpty() &&Character.isUpperCase(s.charAt(0)));
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x ->{
        List<Integer> evenNumbers=x.stream().filter(integer -> integer%2==0).collect(Collectors.toList());
        x.addAll(evenNumbers);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(s -> s.endsWith(".")
             &&Character.isUpperCase(s.charAt(0))
             && s.split("\\s+").length > 3).collect(Collectors.toList());}

    public Function<List<String>, Map<String, Integer>> stringSize() {
     return  x->{

         return x.stream().collect(Collectors.toMap(Function.identity(),String::length));

     };

    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
           List<Integer> list=new ArrayList<>(list1);
           list.addAll(list2);
            return list;

        };

    }
}
