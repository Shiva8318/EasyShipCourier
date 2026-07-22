package com.easyship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.easyship.service.DashboardService;

@Controller
public class ReportController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/reports")
    public String reports(Model model) {

        model.addAttribute("totalUsers",
                dashboardService.getTotalUsers());

        model.addAttribute("totalParcels",
                dashboardService.getTotalParcels());

        model.addAttribute("delivered",
                dashboardService.getDeliveredParcels());

        model.addAttribute("pending",
                dashboardService.getPendingParcels());
        model.addAttribute("recentParcels",
                dashboardService.getRecentParcels());

        return "reports";
    }
    

}