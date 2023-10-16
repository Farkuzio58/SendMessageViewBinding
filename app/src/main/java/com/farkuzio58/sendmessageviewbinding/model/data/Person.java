package com.farkuzio58.sendmessageviewbinding.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase person que engloba la información de una persona de nuestra aplicación
 * @author farku
 * @version 1.0
 */
public class Person implements Parcelable, Serializable {
    public static final String KEY = "Person";
    private String name;
    private String surname;
    private String dni;



    public Person(String n, String s, String d)
    {
        name = n;
        surname = s;
        dni = d;
    }

    protected Person(Parcel in) {
        name = in.readString();
        surname = in.readString();
        dni = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    //region métodos GET y SET de la clase
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o; //DownCasting
        return Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeString(dni);
    }
}
