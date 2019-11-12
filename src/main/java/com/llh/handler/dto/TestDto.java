/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.handler.dto;

import java.util.List;

/**
 *
 * @author lorenzolince
 */
public class TestDto {

    private Integer code;
    private String name;
    private String direction;
    private String street;
    private List<ListTestDto> friends;

    public Integer getCode() {
        return code;
    }

    public TestDto setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public TestDto setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public TestDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public List<ListTestDto> getFriends() {
        return friends;
    }

    public TestDto setFriends(List<ListTestDto> friends) {
        this.friends = friends;
        return this;
    }

    @Override
    public String toString() {
        return "TestDto{" + "code=" + code + ", name=" + name + ", direction=" + direction + ", street=" + street + ", friends=" + friends + '}';
    }
    
}
 