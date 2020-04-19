package com.example.lab3.Models

class Order {

    var id:Int=0
    var Text:String?=null
    var Color:String?=null
    var Price:String?=null

    constructor(){}

    constructor(id:Int, text:String, color: String, price: String){
        this.id=id
        this.Text=text
        this.Color=color
        this.Price=price
    }
}