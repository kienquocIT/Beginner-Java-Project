package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("Welcome to My Todo App");
        System.out.println("1. View Todo list");
        System.out.println("2. Create a new Todo");
        System.out.println("3. Update a Todo");
        System.out.println("4. Delete a Todo");
        System.out.println("0. Exit");
        System.out.println("----------------------------------");

        boolean isExit = false;
        List<Todo> todos = new ArrayList<>();
        while (!isExit) {
            System.out.print("Please enter your choice: ");
            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    System.out.println("View Todo list:");
                    if (todos.isEmpty()) {
                        System.out.println("Todos list is empty");
                    } else {
                        for (int i = 0; i < todos.size(); i++) {
                            System.out.println(i+1 + ". " + todos.get(i).getText() + " - " + todos.get(i).getEndDate());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Create a new Todo:");
                    System.out.print("Text: ");
                    String text = new Scanner(System.in).nextLine();
                    System.out.print("End Date: ");
                    String date = new Scanner(System.in).next();
                    Date endDate = new Date(date);

                    Todo newTodo = new Todo(text, endDate);
                    todos.add(newTodo);
                    break;
                case 3:
                    updateTodos(todos);
                    break;
                case 4:
                    deleteTodo(todos);
                    break;
                case 0:
                    isExit = true;
                    break;

            }
        }
    }

    public static void updateTodos(List<Todo> todos) {
        System.out.println("Update Todo list: ");
        System.out.println("1. Update text");
        System.out.println("2. Update end date");

        System.out.print("- Please choice update: ");
        int choiceUpdate = new Scanner(System.in).nextInt();

        System.out.print("- Please choice a id todo: ");
        int choiceTodo = new Scanner(System.in).nextInt();

        switch (choiceUpdate) {
            case 1:
                System.out.print("Text: ");
                String text = new Scanner(System.in).nextLine();
                todos.get(choiceTodo - 1).setText(text);
                break;
            case 2:
                System.out.print("End Date: ");
                String endDate = new Scanner(System.in).next();
                Date endDateDate = new Date(endDate);
                todos.get(choiceTodo - 1).setEndDate(endDateDate);
        }
    }

    public static void deleteTodo(List<Todo> todos) {
        System.out.println("Delete Todo:");
        System.out.print("- Please choice delete Todo: ");
        int choiceDelete = new Scanner(System.in).nextInt();

        if (todos.isEmpty()) {
            System.out.println("Todos list is empty");
        } else {
            todos.remove(choiceDelete - 1);
            System.out.println("Delete successful!");
        }
    }
}