package com.verinite.paymentservice.controller;

import com.lowagie.text.DocumentException;
import com.verinite.paymentservice.entity.Payments;

import com.verinite.paymentservice.repository.PaymentRepository;
import com.verinite.paymentservice.service.AddingTableToPDF;
import com.verinite.paymentservice.service.PaymentService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.verinite.paymentservice.service.invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping("/savePayment")
    public Payments doPayments(@RequestBody Payments payments) {
        return paymentService.doPayment(payments);
    }

    @GetMapping("getPayment/{id}")
    public Payments getPaymentId(@PathVariable int id) {
        return paymentService.getPaymentId(id);
    }

    @GetMapping("/paymentList")
    public List<Payments> allPayments() {
        return paymentService.allPayment();
    }

    @PutMapping("/updatePayment/{id}")
    public Object updatePayments(@PathVariable int id, @RequestBody Payments payments) {
        return paymentService.updatePayment(id, payments);

    }

    @DeleteMapping("/delete-byId/{id}")
    public String deleteById(@PathVariable("id") int id) {
        return paymentService.deleteById(id);

    }

    @DeleteMapping("/delete-PaymentbyId/{id}")
    public String deleteById1(@PathVariable("id") int id) {
        return paymentService.deleteById1(id);

    }
    @GetMapping("/allPaymentList")
    public List<Payments> allPaymentsUndeletedData() {
        return paymentRepository.getAllPaymentUndeletedList();
    }



    @GetMapping("/users/export/pdf/{paymentId}")
    public void exportToPDF(@PathVariable int paymentId, HttpServletResponse response) throws DocumentException, IOException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Payments> listUsers = paymentService.listAll();
        invoice invoice = new invoice();
        String s = invoice.invoiceNumber(paymentId);
        AddingTableToPDF exporter = new AddingTableToPDF(listUsers,s);
        exporter.export(response,s);

    }
}
