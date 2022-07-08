package com.mercadolivro.controllers

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.service.BookService
import com.mercadolivro.services.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(
    val customerService : CustomerService,
    val bookService: BookService
) {
    @GetMapping
    fun getCustomer(@RequestParam name: String):List<CustomerModel>{
        return customerService.getAll(name)
    }

    @PostMapping
    fun save(@RequestBody customer : CustomerModel) : CustomerModel {
        return customerService.save(customer)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): CustomerModel{
        return customerService.findById(id)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody customer: CustomerModel, @PathVariable id: String){
        customerService.update(customer, id)
    }

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable id: String){
        bookService.findByCustomer(id)
        customerService.destroy(id)
    }
}