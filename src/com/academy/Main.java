package com.academy;

public class Main {

    public static void main(String[] args) {

        MainService mainService = new MainService();

        mainService.welcomeTo();

        mainService.selectCategory(mainService.chooseCategory());

    }

}