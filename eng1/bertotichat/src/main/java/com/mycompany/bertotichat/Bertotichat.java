/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bertotichat;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import java.util.Scanner;

public class Bertotichat {

    public static void main(String[] args) {

        // Initialize the language model
        final ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434/")
                .modelName("duckdb-nsql")
                .temperature(0.8)
                .build();

        // Database schema
        String schema = generateDatabaseSchema();

        // Input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your question:");
        String userQuestion = scanner.nextLine();

        // Generate SQL query based on user's question and database schema
        String sqlQuery = generateSqlQuery(model, userQuestion, schema);

        // Display the generated SQL query
        System.out.println("Generated SQL Query:");
        System.out.println(sqlQuery);
    }

    // Function to generate the database schema
    private static String generateDatabaseSchema() {
        return "CREATE TABLE Users (\n" +
                "    user_id INT PRIMARY KEY,\n" +
                "    name VARCHAR(100),\n" +
                "    email VARCHAR(100),\n" +
                "    date_of_birth DATE,\n" +
                "    city VARCHAR(100)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE Products (\n" +
                "    product_id INT PRIMARY KEY,\n" +
                "    product_name VARCHAR(100),\n" +
                "    description TEXT,\n" +
                "    price DECIMAL(10, 2),\n" +
                "    category VARCHAR(50)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE Orders (\n" +
                "    order_id INT PRIMARY KEY,\n" +
                "    user_id INT,\n" +
                "    product_id INT,\n" +
                "    quantity INT,\n" +
                "    order_date DATE,\n" +
                "    FOREIGN KEY (user_id) REFERENCES Users(user_id),\n" +
                "    FOREIGN KEY (product_id) REFERENCES Products(product_id)\n" +
                ");";
    }

    // Function to generate SQL query based on user's question and database schema
    private static String generateSqlQuery(ChatLanguageModel model, String userQuestion, String schema) {
        return model.generate("Your task is to generate SQL to answer the following question: " +
                userQuestion + "\n given this database schema: " + schema);
    }
}
