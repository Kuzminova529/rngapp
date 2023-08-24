package com.example.rngapp;

import java.io.*;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

import java.io.InputStream;
import java.io.OutputStream;

public class Arduino {
    private static final String PORT_NAME = "COM3"; // Укажите порт, к которому подключен Arduino
    private static final int BAUD_RATE = 9600; // Скорость передачи данных

    public static void main(String[] args) {
        try {
            // Установка соединения с Arduino
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(PORT_NAME);
            SerialPort serialPort = (SerialPort) portIdentifier.open("ArduinoSerial", 2000);
            serialPort.setSerialPortParams(BAUD_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            // Получение потока ввода и вывода
            InputStream input = serialPort.getInputStream();
            OutputStream output = serialPort.getOutputStream();

            // Отправка команды на Arduino
            String command = "start";
            output.write(command.getBytes());

            // Чтение ответа от Arduino
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            //System.out.println("Response from Arduino: " + response);
            try{
                FileWriter writer = new FileWriter("C:\\rngapp\\rng_file.txt");
                writer.write(response);
                writer.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            // Закрытие соединения с Arduino
            serialPort.close();
        } catch (Exception e) {
            e.printStackTrace(); //выволдит ошибку
        }
    }
}
