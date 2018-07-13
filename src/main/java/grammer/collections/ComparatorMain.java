package grammer.collections;

import java.util.*;

public class ComparatorMain {

    static class Person {

        private Integer age;

        private String sex;

        private Integer salary;

        public Person(int age, String sex, int salary){
            this.age = age;
            this.sex = sex;
            this.salary = salary;
        }

        public String toString(){
            return this.age + " " + this.sex + " " + this.salary;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }
    }

    public static void main(String[] args){

        List<Person> company = new ArrayList<>();

        company.add(new Person(22, "male", 6000));
        company.add(new Person(22, "male", 5000));
        company.add(new Person(23, "male", 7000));
        company.add(new Person(25, "female", 3000));
        company.add(new Person(27, "male", 9000));
        company.add(new Person(23, "female", 4000));
        company.add(new Person(27, "female", 9000));

        PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {

            // 升序 : o1 - o2
            // 降序 : o2 - o1
            // 规则 :
            // 1. 按年龄升序
            // 2. 从男到女
            // 3. 按工资降序
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge() == o2.getAge()){

                    if(o1.getSex().equals(o2.getSex())){

                        return o2.getSalary() - o1.getSalary();

                    } else {
                        return o2.getSex().compareTo(o1.getSex());
                    }

                } else {
                    return o1.getAge() - o2.getAge();
                }
            }
        });

        for(Person entry: company){
            pq.offer(entry);
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }



    }


}
