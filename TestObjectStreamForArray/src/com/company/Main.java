package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] numbers = {1,2,3,4};
        String[] strings = {"John","Susan","Kim"};
        // Kreiranje izlaznog toka za datoteku array.dat
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream ("array.dat",true));
            output.writeObject(numbers);
            output.writeObject(strings);

            // zatvaranje toka
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // kreiranje ulaznog toka za datoteku array.dau
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("array.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            int[] newNumbers = (int[])(inputStream.readObject());
            String[] newStrings = (String[]) inputStream.readObject();

            // prikaz niza
            for(int i =0; i<newNumbers.length;i++) {
                System.out.print(newNumbers[i] + " ");
                System.out.println();

            }
                for (int i = 0; i<newStrings.length;i++){
                    System.out.print(newStrings[i] + " ");
                    System.out.println();
                }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
