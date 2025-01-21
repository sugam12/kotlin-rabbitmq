package com.example.demo.controller

import com.example.demo.dto.WorkCenter
import com.example.demo.service.SSFService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ssf-service")
class SSFControllerService(
    @Autowired
    var ssfService: SSFService
) {

    @GetMapping("/work-center")
    fun getWorkOrder(): ResponseEntity<List<WorkCenter>> {
        print("Thread name::" + Thread.currentThread())
        var workOrderList = ssfService.fetchWorkOrder()
        var categories = ssfService.fetchCategories()
        var departments = ssfService.fetchDepartment()

        return ResponseEntity(workOrderList, HttpStatus.OK);
    }
}