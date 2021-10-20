package com.example.getandpost

class People : ArrayList<People.PeopleItem>(){
    data class PeopleItem(
        val name: String,
        val pk: Int
    )
}