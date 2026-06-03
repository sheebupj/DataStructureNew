package com.paremal.sheebu.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MultiOrderParser {

    public record Order(String orderNo, LocalTime time, Double price) {}

    // Regex breakdown:
    // '([^']+)' matches characters inside single quotes and captures them as a group
    /*
      sample input
     [('01','12:30','15.50'),('02','12:40','17.50'),('03','12:30','15.50'),('04','13:30','16.50'),('05','13:30','17.50')]
     */
    private static final Pattern ORDER_PATTERN =
            Pattern.compile("\\('([^']+)','([^']+)','([^']+)'\\)");

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Paste your orders list:");
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                List<Order> batchOrders = new ArrayList<>();
                Matcher matcher = ORDER_PATTERN.matcher(line);

                // Find all occurrences of ('xx','xx','xx') in the line
                while (matcher.find()) {
                    try {
                        String orderNo = matcher.group(1);
                        LocalTime time = LocalTime.parse(matcher.group(2));
                        Double price = Double.valueOf(matcher.group(3));

                        batchOrders.add(new Order(orderNo, time, price));
                    } catch (Exception e) {
                        System.err.println("Error parsing an individual order segment: " + e.getMessage());
                    }
                }

                // Process the collected batch from this line
                System.out.println("--- Parsed " + batchOrders.size() + " orders from line ---");
                batchOrders.forEach(System.out::println);
                Map<Integer,String> hourSummary=batchOrders.stream().collect(
                        Collectors.groupingBy(o-> o.time.getHour(),
                                Collectors.teeing(
                                        Collectors.counting(),
                                        Collectors.averagingDouble(Order::price),
                                        (count,avg)-> count+","+avg)));

                hourSummary.entrySet().forEach(System.out::println);
            }
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
        }
    }
}
