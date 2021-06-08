package com.example.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope

class UserViewModel: ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    fun read(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Database.db.userDao().getAll()
            }
        }
    }

    fun write(firstname: String, lastName: String, age: Int, address: String, height: String, profile: String){
        val user = User(firstname, lastName, age, address, height, profile)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Database.db.userDao().insertUser(user)
            }
        }
    }
}