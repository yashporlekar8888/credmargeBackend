package com.credmarg.credmarg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.credmarg.credmarg.model.Email;
import com.credmarg.credmarg.model.Employee;
import com.credmarg.credmarg.model.Vendor;
import com.credmarg.credmarg.service.EmailService;
import com.credmarg.credmarg.service.EmployeeService;
import com.credmarg.credmarg.service.VendorService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/vendors")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PostMapping("/vendors/email")
    public List<String> sendEmailToVendors() {
        List<Vendor> vendors = vendorService.getAllVendors();
        List<String> emailLogs = new ArrayList<>();

        for (Vendor vendor : vendors) {
            String body = "Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi();
            emailService.sendEmail(vendor.getEmail(), "Vendor Payment", body);

            String log = "Sending email to " + vendor.getEmail() + "\n" +
                         "Subject: Vendor Payment\n" +
                         "Body: " + body;
            emailLogs.add(log);
        }
        return emailLogs;
    }

    @GetMapping("/emails")
    public List<Email> getAllSentEmails() {
        return emailService.getAllSentEmails();
    }
}
