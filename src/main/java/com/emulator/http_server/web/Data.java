package com.emulator.http_server.web;

/*
Класс используется для хранения в памяти данных, полученных из HTML формы
startpage.html. Таксже используется для заполнения полей в result.html
*/
public class Data {

    private String randNumber;
    private String counterValue;
    private String logMessage;

    public String getRandNumber() {
        return randNumber;
    }

    public String getCounterValue() {
        return counterValue;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setRandNumber(String randNumber) {
        this.randNumber = DataService.makeRandNumber(randNumber);
    }

    public void setCounterValue(String counterValue) {
        this.counterValue = DataService.makeCounterValue(counterValue);
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = DataService.logMessageToFile(logMessage);;
    }

}
