package com.easyship.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.easyship.entity.Parcel;
import com.easyship.service.ParcelService;

@Controller
public class ParcelController {

    @Autowired
    private ParcelService service;

    @GetMapping("/bookparcel")
    public String bookParcel() {
        return "bookparcel";
    }

    @PostMapping("/saveparcel")
    public String saveParcel(Parcel parcel, Model model) {

        Parcel savedParcel = service.saveParcel(parcel);

        model.addAttribute("trackingId", savedParcel.getTrackingId());

        model.addAttribute("parcel", savedParcel);

        return "success";
    }
    @GetMapping("/myorders")
    public String myOrders(Model model){

        model.addAttribute("parcels", service.getAllParcels());

        return "myorders";

    }
    @GetMapping("/viewparcel/{id}")
    public String viewParcel(@PathVariable Integer id, Model model){

        Parcel parcel = service.getParcelById(id);

        model.addAttribute("parcel", parcel);

        return "viewparcel";

        
    }
    @GetMapping("/track")
    public String trackPage() {

        return "track";

    }
    @PostMapping("/trackparcel")
    public String trackParcel(@RequestParam String trackingId,
                              Model model) {

        Parcel parcel = service.getParcelByTrackingId(trackingId);

        if (parcel == null) {

            model.addAttribute("error",
                    "Tracking ID not found!");

            return "track";

        }

        model.addAttribute("parcel", parcel);

        return "trackingresult";

    }

}