package com.example.fragmentswithrecyclerview12272019;

import android.app.Application;

import java.util.ArrayList;


public class ApplicationClass extends Application {
    public static ArrayList<Person> people ;

    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<Person>();
        people.add(new Person("John", "515425455"));
        people.add(new Person("Ajaya", "515425455"));
        people.add(new Person("Salina", "515425455"));
        people.add(new Person("Ashma", "515425455"));
        people.add(new Person("Reshma", "515425455"));
        people.add(new Person("Jackie", "515425455"));
        people.add(new Person("Sujan", "515425455"));


    }
}

