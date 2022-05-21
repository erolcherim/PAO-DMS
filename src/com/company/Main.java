package com.company;

import com.company.classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {

        Meniu meniu = Meniu.getInstance();
        meniu.showMeniu();
    }
}
