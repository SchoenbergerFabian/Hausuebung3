package com.Infendro.Beispiel1;

import java.util.List;

public class Print {

    private Printable printNormal = weapons -> {
        weapons.forEach(System.out::println);
    };

    private Printable printTable = weapons -> {
        new Table(weapons).print();
    };

    public void printNormal(List<Weapon> weapons){
        printNormal.print(weapons);
    }

    public void printTable(List<Weapon> weapons){
        printTable.print(weapons);
    }

    public void setPrintNormal(Printable printNormal) {
        this.printNormal = printNormal;
    }

    public void setPrintTable(Printable printTable) {
        this.printTable = printTable;
    }
}
