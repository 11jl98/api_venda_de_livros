package com.mercadolivro.services

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    fun getAll(name: String): List<CustomerModel>{
        name.let {
            return customerRepository.findByName(it)
        }
        return customerRepository.findAll() as List<CustomerModel>
    }

    fun save(customer: CustomerModel) : CustomerModel{
       return customerRepository.save(customer)
    }

    fun findById(id: String): CustomerModel{
       return customerRepository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel, id: String){
        if(!customerRepository.existsById(id)) throw Exception()

        customerRepository.save(customer)
    }

    fun destroy(id: String){
        if(!customerRepository.existsById(id)) throw Exception()

        customerRepository.deleteById(id)
    }
}