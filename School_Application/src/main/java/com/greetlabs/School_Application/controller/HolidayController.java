package com.greetlabs.School_Application.controller;

import com.greetlabs.School_Application.model.Holiday;
import com.greetlabs.School_Application.reository.HolidayRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HolidayController {

    private HolidayRepository holidayRepository;

    public HolidayController(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @GetMapping("/holidays")
    public String displayHolidays(Model model) {
        return displayHolidays("all", model);
    }

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model){
        if(null != display && display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        } else if (null != display && display.equals("federal")) {
            model.addAttribute("federal",true);
        } else if (null != display && display.equals("festival")) {
            model.addAttribute("festival",true);
        }
        Iterable<Holiday> holidays = holidayRepository.findAll();
        List<Holiday> holidayList= StreamSupport.stream(holidays.spliterator(),false)
                .collect(Collectors.toList());
        Holiday.Type[] types =Holiday.Type.values();
        for(Holiday.Type type : types){
            model.addAttribute(type.toString(),
                    (holidayList.stream()
                            .filter(holiday -> holiday.getHolidayType().equals(type))
                            .collect(Collectors.toList())));
        }
        return "holiday";
    }
//    @GetMapping("/holidays")
//    public String displayHolidays(Model model){
//        List<Holiday> holidays= Arrays.asList(
//                new Holiday("Jan 1","New Year's Day",Holiday.Type.FESTIVAL),
//                new Holiday("Oct 31","Halloween",Holiday.Type.FESTIVAL),
//                new Holiday("Nov 24","Thanksgiving Day",Holiday.Type.FEDERAL),
//                new Holiday("Dec 25","Christmas day",Holiday.Type.FESTIVAL),
//                new Holiday("Jan 15","Sankranti",Holiday.Type.FESTIVAL),
//                new Holiday("Aug 15","Independence Day",Holiday.Type.FEDERAL),
//                new Holiday("Sep 5","Labor Day",Holiday.Type.FEDERAL),
//                new Holiday("Nov 11","Veterans Day",Holiday.Type.FEDERAL)
//        );
//        Holiday.Type[] types=Holiday.Type.values();
//        for (Holiday.Type type :types){
//            model.addAttribute(type.toString(),
//                    (holidays.stream().filter(holiday -> holiday.getType()
//                            .equals(type))
//                            .collect(Collectors.toList())));
//        }
//        return "holiday.html";
//    }
}
