package ru.skillbranch.devintensive.extensions

fun String.truncate(value : Int = 16):String{
    return if (this.trim().length>=value) this.removeRange(16,length).trim()+"..." else this.trim()

}