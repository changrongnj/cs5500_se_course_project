package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController  // this class is a controller
@RequestMapping("/visits")  // the URL start with /visits
public class MainController {
    @GetMapping(path="/all")
    public @ResponseBody List<Visit> getAllVisits() {
        List<Visit> visits = new ArrayList<>();
        DataSet ds = ; // Rong: I think this is the different dataset from database?
        return ds.getVisits();
    }

    @GetMapping(path="/filter-{parameter}") //filter visits by parameter specified


    @GetMapping(path="/order-by-{parameter}") //presenting data by parameter specified


    @PostMapping(path = "/add") //add a visit data

    @PostMapping(path = "/add-by-form") //add a visit data via form
    public String addNewVisitForm() {

    }
}