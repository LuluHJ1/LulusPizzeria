package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    public static void saveReceipt(Order order) {
        try {
            //current date/time
            LocalDateTime now = LocalDateTime.now();

            //format date time
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyMMdd-HHmmss");

            String fileName =
                    "Receipts/" +
                    now.format(formatter) +
                    ".txt";

            FileWriter writer =
                    new FileWriter(fileName);

            writer.write(order.formatReceipt());

            writer.close();

            System.out.println("Receipt saved.");
        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }
}
