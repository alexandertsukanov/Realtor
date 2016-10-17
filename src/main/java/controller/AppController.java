package controller;


import entity.Visitors;
import form.ReservationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import repository.OwnersRepository;
import repository.PropertiesRepository;
import repository.VisitorsRepository;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class AppController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
        binder.registerCustomEditor(Date.class, "reservedDate", new CustomDateEditor(sdf, true));

    }

    @Autowired
    private PropertiesRepository propertiesRepository;

    @Autowired
    private OwnersRepository ownersRepository;

    @Autowired
    private VisitorsRepository visitorsRepository;

    @RequestMapping(value = "/properties", method = RequestMethod.GET)

    public String getProperties(Model model) {
        model.addAttribute("property", propertiesRepository.findAll(new Sort("id")));
        return "properties";
    }


    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public String getPropertyReservations(@PathVariable("id") Long id, Model model) {
        ReservationForm form = new ReservationForm();
        model.addAttribute("visitor", visitorsRepository.findByReservedProperty(id));
        model.addAttribute("ReservationForm", form);
        return "reservation";
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.POST)
    public String Reservate(@Valid @ModelAttribute("ReservationForm") ReservationForm reservationForm, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("visitor", visitorsRepository.findByReservedProperty(id));
            return "reservation";
        }
        model.addAttribute("visitor", visitorsRepository.findByReservedProperty(id));
        Visitors visitors = new Visitors();
        visitors.setFirstName(reservationForm.getFirstName());
        visitors.setSecondName(reservationForm.getSecondName());
        visitors.setMiddleName(reservationForm.getMiddleName());
        visitors.setPhone(reservationForm.getPhone());
        visitors.setReservedProperty(id);
        visitors.setReservedDate(reservationForm.getReservedDate());
        visitorsRepository.save(visitors);
        model.addAttribute("success", "You reservation succeed");
        return "reservation";
    }


    @ExceptionHandler(Exception.class)
    public String errorHandler(Model model) {
        ReservationForm form = new ReservationForm();
        model.addAttribute("ReservationForm", form);
        model.addAttribute("error", "Please, choose another reservation time");
        return "reservation";

    }

}

