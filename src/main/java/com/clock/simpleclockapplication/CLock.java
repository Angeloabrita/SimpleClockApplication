/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clock.simpleclockapplication;

/**
 *
 * @author angel
 */
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.time.LocalTime;

public class CLock extends Canvas {

    private GraphicsContext gc;

    public CLock(double width, double height) {
        super(width, height);
        gc = getGraphicsContext2D();
        drawClockFace();
    }

    private void drawClockFace() {
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double radius = Math.min(centerX, centerY) * 0.9;

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, getWidth(), getHeight());

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        // Draw hour markers
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30);
            double x = centerX + radius * 0.8 * Math.sin(angle);
            double y = centerY - radius * 0.8 * Math.cos(angle);
            gc.strokeLine(x, y, x + 5 * Math.sin(angle), y - 5 * Math.cos(angle));
        }
    }

    public void updateClock() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double radius = Math.min(centerX, centerY) * 0.8;

        // Clear previous hands (important!)
        gc.clearRect(0, 0, getWidth(), getHeight());
        drawClockFace(); // Redraw the clock face

        // Hour hand
        double hourAngle = Math.toRadians((hour % 12 + minute / 60.0) * 30);
        double hourX = centerX + radius * 0.5 * Math.sin(hourAngle);
        double hourY = centerY - radius * 0.5 * Math.cos(hourAngle);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(4);
        gc.strokeLine(centerX, centerY, hourX, hourY);

        // Minute hand
        double minuteAngle = Math.toRadians(minute * 6);
        double minuteX = centerX + radius * 0.7 * Math.sin(minuteAngle);
        double minuteY = centerY - radius * 0.7 * Math.cos(minuteAngle);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(3);
        gc.strokeLine(centerX, centerY, minuteX, minuteY);

        // Second hand
        double secondAngle = Math.toRadians(second * 6);
        double secondX = centerX + radius * 0.9 * Math.sin(secondAngle);
        double secondY = centerY - radius * 0.9 * Math.cos(secondAngle);
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeLine(centerX, centerY, secondX, secondY);
    }
}