package com.easyship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.easyship.service.ParcelService;

@Controller
public class ManageParcelController {

    @Autowired
    private ParcelService service;

    // ==============================
    // Open Manage Parcel Page
    // ==============================
    @GetMapping("/manageparcels")
    public String manageParcels(Model model) {

        model.addAttribute("parcelList",
                service.getAllParcels());

        return "manageparcels";
    }

    // ==============================
    // Update Parcel Status
    // ==============================
    @PostMapping("/updateStatus")
    public String updateStatus(

            @RequestParam Integer id,
            @RequestParam String status

    ) {

        service.updateStatus(id, status);

        return "redirect:/manageparcels";

    }

}