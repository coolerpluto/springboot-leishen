package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {
    @GetMapping("/basic_table.html")
    public String basicTable(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table.html")
    public String dynamicTable(){
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table.html")
    public String responsiveTable(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table.html")
    public String editableTable(){
        return "table/editable_table";
    }
}
