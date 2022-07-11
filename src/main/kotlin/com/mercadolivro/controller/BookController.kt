package com.mercadolivro.controller

import com.mercadolivro.model.BookModel
import com.mercadolivro.service.BookService
import com.mercadolivro.services.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("Book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {
    @PostMapping
    fun save(@RequestBody book : BookModel): BookModel{
        println(book)
        return bookService.save(book)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody book: BookModel, @PathVariable id: String){
        bookService.update(book, id)
    }

    @GetMapping
    fun getAll(): List<BookModel>{
        return bookService.findAll()
    }

    @GetMapping("/active")
    fun findByStatus(): List<BookModel>{
        return bookService.finByStatus()
    }

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable id: String){
        bookService.destroy(id)
    }

}