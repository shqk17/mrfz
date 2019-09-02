package com.mrfz.bean;

public enum HeroJobEnum {
    狙击(1,"狙击"),
    术士(2,"术士"),
    先锋(3,"先锋"),
    近卫(4,"近卫"),
    重装(5,"重装"),
    医疗(6,"医疗"),
    辅助(7,"辅助"),
    特种(8,"特种");

    HeroJobEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    public static String getName(String jobId) {
        switch (jobId){
            case "1":return  "狙击";
            case "2":return  "术士";
            case "3":return  "先锋";
            case "4":return  "近卫";
            case "5":return  "重装";
            case "6":return  "医疗";
            case "7":return  "辅助";
            case "8":return  "特种";
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
