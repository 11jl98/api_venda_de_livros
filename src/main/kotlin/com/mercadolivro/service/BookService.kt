package com.mercadolivro.service

import com.mercadolivro.enums.BooksEnum
import com.mercadolivro.model.BookModel
import com.mercadolivro.repository.BookRepository


class BookService(
   val bookRepository: BookRepository
) {
    fun findAll(): List<BookModel>{
        return bookRepository.findAll().toList()
    }
    fun finByStatus(): List<BookModel>{
       return bookRepository.findByStatus(BooksEnum.ATIVO)
    }
    fun finByid(id: String): BookModel{
        return bookRepository.findById(id).orElseThrow()
    }

    fun save(book: BookModel): BookModel{
        if(book.customer_id == null) return throw Exception()

        return bookRepository.save(book)
    }
    fun update(book: BookModel, id: String){
        if(!bookRepository.existsById(id)) return throw Exception()

        bookRepository.save(book)
    }

    fun destroy(id: String){
       val book = finByid(id)

        book.status = BooksEnum.CANCELADO
        bookRepository.save(book)
    }

    fun findByCustomer(customer_id: String){
        val books = bookRepository.findByCustomer(customer_id)

        for(book in books){
            book.status = BooksEnum.DELETADO
        }
        bookRepository.saveAll(books)
    }
}