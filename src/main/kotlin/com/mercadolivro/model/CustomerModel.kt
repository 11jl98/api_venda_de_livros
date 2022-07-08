package com.mercadolivro.model

import java.util.UUID

import javax.persistence.*

@Entity(name = "customer")
data class CustomerModel(
    @Id
    var id: String ? = UUID.randomUUID().toString(),

    @Column
    var name: String,

    @Column
    var email: String,
)