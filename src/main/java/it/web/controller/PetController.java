package it.web.controller;

import it.web.bean.Pet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class PetController {

    @RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("homePage");
        return model;
    } 
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Pet> list(ModelMap model) {
        List<Pet> list = getList();
        return list;
    } 
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public @ResponseBody String dalete(ModelMap model) {
        
        return "Deleted";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody String add(ModelMap model) {
        
        return "Added";
    }

    private List<Pet> getList() {

        List<Pet> list = new ArrayList<Pet>();
        Pet pet = new Pet();
        pet.setId(1);
        pet.setCode("p1");
        pet.setName("name1");
        list.add(pet);
        pet = new Pet();
        pet.setId(2);
        pet.setCode("p2");
        pet.setName("name2");
        list.add(pet);
        return list;

    }

}
