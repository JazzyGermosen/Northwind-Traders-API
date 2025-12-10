package com.pluralsight.NorthwindTradersAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    // creating a method that will respond to the local host 8080
    // when they go to the base url they will return nthis string
    @GetMapping("/")
    // this method will respond to local host 8080
    public String index(
            // dont entirely understand whats going on here but we are creating a paramater in the indext to return the default vaule country
            // setting country the string to USA
            @RequestParam(defaultValue = "?country=USA")String country
    ){

        // if the country value is not true or country is empty then reuturn first statement
        // else return basic statement
        // !country.isEmpty means that the country condition is true and the reverse would be false
        if (country != null && !country.isEmpty()) {
            return "Hello darkness " + country + "my old friend";
        }else {
            return "Hello darkness my old friend";
        }
    }
}
