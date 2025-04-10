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

import static java.lang.Character.isUpperCase;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x ->{for(String s : x) {if(!isUpperCase(s.trim().charAt(0))) {return false;}}return true;};
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenNumbers = new ArrayList<>();
            for (Integer num : x) {
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                }
            }
            x.addAll(evenNumbers);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        List<String> result = new ArrayList<>();
        for(String s : values) {
            s=s.trim();
            String[] words = s.split("\\s+");
            if(isUpperCase(s.charAt(0)) && s.charAt(s.length()-1) =='.' && words.length > 3 ) {
                result.add(s);
            }
        }
        return ()->result;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return l -> {Map<String, Integer> result = new HashMap<>();for (String s : l) {result.put(s, s.length());}return result;};
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (l1,l2)  -> { List<Integer> result = new ArrayList<>();
            result.addAll(l1);
            result.addAll(l2);
            return result;};
    }
}
