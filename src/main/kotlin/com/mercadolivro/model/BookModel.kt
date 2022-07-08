package com.mercadolivro.model

import com.mercadolivro.enums.BooksEnum
import java.math.BigDecimal
import java.util.UUID

import javax.persistence.*

@Entity(name = "book")
data class BookModel(
    @Id
    var id: String ? = UUID.randomUUID().toString(),

    @ManyToOne
    @JoinColumn
    var customer_id: String? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BooksEnum? = null,
)