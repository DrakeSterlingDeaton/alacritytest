package alacrityproject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;import java.util.ArrayList;

@Controller
public class BaseController {


    @GetMapping("/")
    public RedirectView redirectView() {
        return new RedirectView("/index");
    }

    @GetMapping("/index")
    public ModelAndView getIndexPage() {

        ModelAndView mv = addData();

        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value="/indexPagePost", method= RequestMethod.POST)
    public ModelAndView receivePost(@RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "age", required = false) String age) {
        ModelAndView mv = addData();

        mv.addObject("person4", "Name: " + name + " Age: " + age);

        mv.setViewName("index");
        return mv;
    }

    public ArrayList<Person> initPersonsLi() {

        Person person1 = new Person("Alice", 20);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Carol", 30);
        Person person4 = new Person("Dave", 35);

        ArrayList<Person> person_li = new ArrayList<Person>();
        person_li.add(person1);
        person_li.add(person2);
        person_li.add(person3);
        person_li.add(person4);

        return person_li;
    }

    public ModelAndView addData() {
        ModelAndView mv = new ModelAndView();

        ArrayList<Person> person_li = initPersonsLi();
        PersonClassCalculator calculator = new PersonClassCalculator();

        int averageAge = calculator.getAverageAge(person_li);
        Person oldestPerson = calculator.getOldestPerson(person_li);
        Person youngestPerson = calculator.getYoungestPerson(person_li);
        mv.addObject("averageAge", averageAge);
        mv.addObject("oldestPerson", "Name: " + oldestPerson.getName() + " Age: " + oldestPerson.getAge());
        mv.addObject("youngestPerson", "Name: " + youngestPerson.getName() + " Age: " + youngestPerson.getAge());

        for (int i = 0; i < person_li.size(); i++) {
            Person person = person_li.get(i);
            mv.addObject("person" + i, "Name: " + person.getName() + " Age: " + person.getAge());
        }

        return mv;
    }

}