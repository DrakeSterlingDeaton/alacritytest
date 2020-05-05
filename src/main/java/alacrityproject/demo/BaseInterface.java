package alacrityproject.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;import java.util.ArrayList;


@Controller
interface BaseInterface {

    public RedirectView redirectView();

    public ModelAndView getIndexPage();

    public ModelAndView receivePost(String name, String age);

    public ArrayList<Person> initPersonsLi();

    public ModelAndView addData();

}