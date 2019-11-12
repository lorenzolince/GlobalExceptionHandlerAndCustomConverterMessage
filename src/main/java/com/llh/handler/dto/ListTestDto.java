/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.handler.dto;

/**
 *
 * @author lorenzolince
 */
public class ListTestDto {

    public ListTestDto() {
    }
    private String name;
    private String tel;
    private String email;

    public String getName() {
        return name;
    }

    public ListTestDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public ListTestDto setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ListTestDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "ListTestDto{" + "name=" + name + ", tel=" + tel + ", email=" + email + '}';
    }

}
