package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    public ArrayList<HashMap<String, String>> jobs;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results", method = RequestMethod.GET)
    public String Search(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {
        model.addAttribute("columns", ListController.columnChoices);
        if(searchType.equals("all"))
        {
            model.addAttribute("jobs", JobData.findByValue(searchTerm));
        }
        else {
            model.addAttribute("jobs", JobData.findByColumnAndValue(searchType, searchTerm));
        }
            return "search";

        }
//    @RequestMapping(value = "results")
  //  public String Search(Model model, @RequestParam String searchTerm) {
    //    model.addAttribute("columns", ListController.columnChoices);
//
  //      model.addAttribute("jobs", JobData.findByValue(searchTerm));
    //    return "search";

    //}
    }
