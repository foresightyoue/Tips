package org.youe.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListUtils {

    public static String getLastByIndex(List<String> list) {
        if (null != list) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    public static String getLastBySkip(List<String> list) {
        return list.stream().skip(list.size() - 1).findFirst().orElse(null);
    }

    public static String getLastByReduce(List<String> list) {
        return list.stream().reduce((f, s) -> s).orElse(null);
    }

    public static List<String> distinctList(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static List<String> distinctListIdInPerson(List<Person> list) {
        return list.stream().map(Person::getId).distinct().collect(Collectors.toList());
    }

    public static List<String> distinctListIdInPersonByMap(List<Person> list) {
//        list.stream().map(Person::getId).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        return list.stream().map(Person::getId).distinct().collect(Collectors.toList());
    }

    public static List<Person> distinctListPersonByCollectingAndThen(List<Person> list) {
        return list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getId))),
                ArrayList<Person>::new));
    }

    public static List<Person> distinctListPersonByCollectingAndThenWithIdAndName(List<Person> list) {
        return list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(p -> p.getId() + ":"
                + p.getName()))), ArrayList::new));
    }

    public static List<Person> distinctListPersonByFilter(List<Person> list) {
        List<String> filterList = new ArrayList<>();
        return list.stream().filter(p -> {
            boolean contains = !filterList.contains(p.getId());
            filterList.add(p.getId());
            return contains;
        }).collect(Collectors.toList());
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> exit = new ConcurrentHashMap<>();
        return o -> exit.putIfAbsent(keyExtractor.apply(o), Boolean.TRUE) == null;
    }

    public static List<Person> distinctListPersonByKey(List<Person> list) {
        return list.stream().filter(distinctByKey(Person::getId)).collect(Collectors.toList());
    }

    public static String distinctListToString(List<String> list) {
        return list.stream().distinct().collect(Collectors.joining(","));
    }

    public static Boolean hasRepeatId(List<Person> list) {
        List<String> distinctList = list.stream().map(Person::getId).distinct().collect(Collectors.toList());
        return distinctList.size() != list.size();
    }



}
