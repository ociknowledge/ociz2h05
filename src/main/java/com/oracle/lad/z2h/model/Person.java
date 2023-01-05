package com.oracle.lad.z2h.model;

public class Person {

    private int id;
    private String name;
    private String email;
    private String roleName;
    private String phone;
    private String countryCode;

    public Person() {
    }

    public Person(final int id, final String name, final String email, final String roleName, final String phone, final String countryCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roleName = roleName;
        this.phone = phone;
        this.countryCode = countryCode;
    }

    public Person(final String name, final String email, final String roleName, final String phone, final String countryCode) {
        this.name = name;
        this.email = email;
        this.roleName = roleName;
        this.phone = phone;
        this.countryCode = countryCode;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }
}
