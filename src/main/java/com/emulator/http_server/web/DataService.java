package com.emulator.http_server.web;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
Класс используется для обработки полученных из формы данных
в соответствии с заданной логикой.
 */
public class DataService {
    static ArrayList<String> counterMemory = new ArrayList<>();

    // Строковое значение парсится на два числа,
    // задающих диапазон для генерации случайного значения
    static String makeRandNumber(String rangeNum){
        String randNumber = rangeNum.trim();
        if (" ".equals(randNumber) || "".equals(randNumber) || randNumber == null) {
            return "You did enter nothing. Please enter range.";
        } else {
            String[] range = randNumber.split("-");
            if (range.length == 2 && !("".equals(range[0]))) {
                try {
                    Integer min = Integer.parseInt(range[0]);
                    Integer max = Integer.parseInt(range[1]);
                    if (min < max) {
                        Integer randNum = (int) ((Math.random() * (max - min)) + min);
                        ;
                        return "".concat(String.valueOf(randNum));
                    } else {
                        return "".concat(randNumber + " - no valid value. First number must be lesser second number.");
                    }
                } catch (NumberFormatException e) {
                    return "".concat(randNumber + " - no valid value. Please enter two numbers. Example: 5-17.");
                }
            } else {
                return "".concat(randNumber + " - no valid value. Please enter two numbers. Example: 5-17.");
            }
        }
    }

    // Строковое значение парсится и складывается со значением в памяти, а затем
    // возвращается. Поступившее значение записывается в массив для дальнейшего использования.
    static String makeCounterValue(String value){
        String counterValue = value.trim();
        if ("".equals(counterValue) || counterValue == null){
            return "You did enter nothing. Please enter number.";
        } else {
            try {
                Integer countVal = Integer.parseInt(counterValue);
                if (countVal >= 0) {
                    Integer sum = 0;
                    for (String num : counterMemory) {
                        sum += Integer.parseInt(num);
                    }
                    String resultCounterValue = String.valueOf(sum + countVal);
                    counterMemory.add(counterValue);
                    return resultCounterValue;
                } else {
                    return "".concat(counterValue + " - no valid value. Please enter number greter 0 or 0. Example: 5.");
                }
            } catch (NumberFormatException e) {
                return "".concat(counterValue + " - no valid value. Please enter number. Example: 5.");
            }
        }
    }

    // Строковое значение записывается в log.txt.
    // Пользователю возвращается результат выполнения.
    static String logMessageToFile(String message){
        String logMessage = message.trim();
        if ("".equals(logMessage) || logMessage == null){
            return "You did enter nothing. Please enter message.";
        } else{
            try (FileWriter writer = new FileWriter("log.txt", true)) {
                writer.write(logMessage);
                writer.append('\n');
                writer.flush();
                return "Message " + "\"" + logMessage + "\" " + "have logged";
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return "Message " + "\"" + logMessage + "\" " + "not have logged";
            }
        }
    }
}
