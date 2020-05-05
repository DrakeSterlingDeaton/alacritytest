package alacrityproject.demo;

import org.thymeleaf.standard.processor.StandardObjectTagProcessor;import java.util.ArrayList;public class PersonClassCalculator {

    public PersonClassCalculator() {}

   public int getAverageAge(ArrayList<Person> person_li){
        int totalAge = 0;
        int totalPersons = 0;
        for (int i = 0; i < person_li.size(); i++) {
            Person person = person_li.get(i);
            totalAge += person.getAge();
            totalPersons += 1;
        }
        return totalAge/totalPersons;
   }

   public Person getOldestPerson(ArrayList<Person> person_li){
        int oldestPersonAge = 0;
        Person oldestPerson = null;
        for (int i = 0; i < person_li.size(); i++) {
            Person person = person_li.get(i);
            if (person.getAge() > oldestPersonAge) {
                oldestPersonAge = person.getAge();
                oldestPerson = person;
            }
        }
       return oldestPerson;
   }

    public Person getYoungestPerson(ArrayList<Person> person_li){
        int youngestPersonAge = 100;
        Person youngestPerson = null;
        for (int i = 0; i < person_li.size(); i++) {
            Person person = person_li.get(i);
            if (person.getAge() < youngestPersonAge) {
                youngestPersonAge = person.getAge();
                youngestPerson = person;
            }
        }
        return youngestPerson;
    }

}
