package com.example.lab3.Models

class Order {

    var Id:Int?=null
    var Text:String?=null
    var Color:String?=null
    var Price:String?=null

    constructor(){}

    constructor(id:Int, text:String, color: String, price: String){
        this.Id=id
        this.Text=text
        this.Color=color
        this.Price=price
    }
}