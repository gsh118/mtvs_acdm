package com.ohgiraffers.common;

public class MemberDTO {

    private Long id;
    private String name;

    public MemberDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
