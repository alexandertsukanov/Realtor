package controller;

import form.ReservationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.OwnersRepository;
import repository.PropertiesRepository;



@Controller
public class AppController {

    @Autowired
    private PropertiesRepository propertiesRepository;

    @Autowired
    private OwnersRepository ownersRepository;

    @RequestMapping (value = "/properties", method = RequestMethod.GET)

        public String getProperties(Model model){
        model.addAttribute("property", propertiesRepository.findAll(new Sort("id")));
        return "properties";
        }

    @RequestMapping (value = "/reservation", method = RequestMethod.GET)
    public String getReservations(Model model){

        model.addAttribute("ReservationForm", new ReservationForm());
        return "reservation";
    }

}

