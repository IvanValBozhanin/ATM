/*
 * MIT License
 *
 * Copyright (c) 2020 Ivan Valentinov Bozhanin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int numOfAccounts = 10;
        Account [] listOfAccounts = new Account[numOfAccounts];
        for(int i=0;i<numOfAccounts;++i){
            listOfAccounts[i] = new Account(i, 100);
        }
        int id;

        while (true){
            do {
                System.out.print("Enter an id: ");
                id = in.nextInt();
                if(id == 99) {break;}
                if(id > numOfAccounts - 1 || id < 0){
                    System.out.println("Wrong ID, please, enter again.");
                }
            }while (id > numOfAccounts - 1 || id < 0);
            if(id == 99) break;
            boolean inAccount = true;
            while (inAccount) {
                System.out.println("Main menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                byte option = in.nextByte();
                switch (option) {
                    case (1) -> System.out.println(listOfAccounts[id].getBalance());
                    case (2) -> {
                        System.out.print("Enter an amount to withdraw: ");
                        listOfAccounts[id].setBalance(listOfAccounts[id].getBalance() - in.nextDouble());
                    }
                    case (3) -> {
                        System.out.print("Enter an amount to deposit: ");
                        listOfAccounts[id].setBalance(listOfAccounts[id].getBalance() + in.nextDouble());
                    }
                    case (4) -> inAccount = false;
                }
            }
        }
    }
}
