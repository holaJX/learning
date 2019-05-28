package karp.泛型;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: pujx
 * @Date: 2019/5/16 19:19
 * java 8引入lambd后对集合的操作学习
 */
public class ListTest {

    public static void main(String[] args) {
        List<CheckWeekVO> checkWeekVOList =new ArrayList<>();
        for (int i=0;i<100;i ++){
            CheckWeekVO  vo= new CheckWeekVO();
            vo.setTitle("chest"+i);
            vo.setAge(i);
            vo.setWeight(i+100);
            vo.setClsc(i);
            vo.setFileunid(UUID.randomUUID().toString());
            checkWeekVOList.add(vo);
        }
        List<CheckWeekVO> collect = checkWeekVOList.parallelStream()
                .filter(e -> e.getTitle().contains("5")).collect(Collectors.toList());
        System.out.println("---------------------总共找到："+collect.size());
        System.out.println("###############################################");
        System.out.println( "分别为：");
        System.out.println();
        System.out.println("-------------------filter 过滤条件里面可以有 equals  contains 等---------------");
        System.out.println("###############################################");
        System.out.println( "分别为：");
        Optional<CheckWeekVO> first = checkWeekVOList.parallelStream().filter(e->e.getTitle().contains("8")).findFirst();
        System.out.println(first.get());
        System.out.println("-------------------sorted ---------------");
        Optional<String> hcCity = Optional.ofNullable(first.get().getHcCity());
        System.out.println("------------------------>"+hcCity.get());
        List<CheckWeekVO> collect1 = checkWeekVOList.stream().filter(b -> b.getAge() > 18)
                .sorted((x, y) -> x.getWeight() - x.getWeight()).collect(Collectors.toList());
        collect1.forEach(e-> System.out.println(e.toString()));
//
        System.out.println("-------------------map 映射对象---------------");
        List<Person> collect2 = checkWeekVOList.stream().filter(b -> b.getAge() > 18)
                .sorted((x, y) -> x.getWeight() - x.getWeight())
                .map(e -> new Person(e.getAge(), e.getTitle(), e.getWeight())).collect(Collectors.toList());
        collect2.forEach(person -> System.out.println(person.toString()));

        System.out.println("-------------------max ---------------");
        OptionalInt max = collect2.stream().mapToInt(Person::  getWeight).max();
        System.out.println("获取最大值为："+max);
        System.out.println("-------------------groupingBy ---------------");
        Map<String, List<Person>> collect3 = collect2.stream().collect(Collectors.groupingBy((person) -> {
            if (person.getAge() > 60)
                return "老年人";
            else if (person.getAge() > 40 && person.getAge() < 60)
                return "中年人";
            else
                return "青年人";

        }));

        for (String key: collect3.keySet()
             ) {
            System.out.println("key--->"+key +"共有"+collect3.get(key).size());
            for ( Person p:collect3.get(key)
                 ) {
                System.out.println(p.toString());
            }
        }

        System.out.println("");

    }
}
