package com.mercadolivro.repository

import com.mercadolivro.enums.BooksEnum
import com.mercadolivro.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, String> {

    fun findByStatus(status: BooksEnum) : List<BookModel>
    fun findByCustomer(customer_id: String) : List<BookModel>
}