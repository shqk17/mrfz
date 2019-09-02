package com.mrfz.bean;

public enum HeroPlaceEnum {
    近战位(1,"近战位"),
    远程位(2,"远程位"),
    输出(3,"输出"),
    当前暂不实装4(4,"当前暂不实装");

    HeroPlaceEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    public static String getName(String placeId) {
        switch (placeId){
            case "1":return  "近战位";
            case "2":return  "远程位";
            case "3":return  "输出";
            case "4":return  "当前暂不实装";
            default:
                return "";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
