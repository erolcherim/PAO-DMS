package com.company;

import com.company.classes.*;
import com.company.services.LoggerService.LoggerService;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Menu meniu = Menu.getInstance();
        meniu.showMeniu();
    }
}
