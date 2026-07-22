package com.easyship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.easyship.repository.ParcelRepository;
import com.easyship.repository.UserRepository;
import com.easyship.service.DashboardService;

import com.easyship.entity.Admin;
import com.easyship.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ParcelRepository parcelRepository;

    @Autowired
    private AdminService service;
    @Autowired
    private DashboardService dashboardService;

    // Open Admin Login Page
    @GetMapping("/admin")
    public String adminLoginPage() {

        return "adminlogin";

    }

    // Process Admin Login
    @PostMapping("/adminlogin")
    public String adminLogin(@RequestParam String email,
                             @RequestParam String password,
                             HttpSession session,
                             Model model) {

        Admin admin = service.login(email, password);

        if (admin != null) {

            session.setAttribute("admin", admin);

            return "redirect:/admindashboard";

        }

        model.addAttribute("error", "Invalid Email or Password");

        return "adminlogin";

    }
    @GetMapping("/admindashboard")
    public String adminDashboard(Model model, HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin";
        }

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

        return "admindashboard";
    }
}