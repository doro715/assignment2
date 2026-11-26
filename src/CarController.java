import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // The delay (ms) corresponds to 20 updates/second (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // TODO A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    public void startTimer() {
        this.timer.start();
    }

    /* Each step, the TimerListener moves all cars in the list and tells the
     * view to update its images. TODO Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                if (x > frame.drawPanel.getWidth() - 200 || y > frame.drawPanel.getHeight() - 150 || x < 0 || y < 0) {
                    car.stopEngine();
                    car.turnLeft();
                    car.turnLeft();
                    int maxX = frame.drawPanel.getWidth() - 200;
                    int newX = Math.max(0, Math.min(x, maxX));
                    int maxY = frame.drawPanel.getHeight() - 150;
                    int newY = Math.max(0, Math.min(y, maxY));
                    car.setPosition(newX, newY);
                    x = newX;
                    y = newY;
                    car.startEngine();
                }
                frame.drawPanel.moveit(i, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.revalidate();
                frame.drawPanel.repaint();
            }

        }
    }

    void gas(int amount) {

        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }

    }

    void brake(int amount) {

        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void turnLeft (){

        for (Car car : cars){
            car.turnLeft();
        }
    }
    void turnRight () {

        for (Car car : cars) {
            car.turnRight();
        }
    }
    void startEngine () {

        for (Car car : cars){
            car.startEngine();
        }
    }
    void stopEngine() {

        for (Car car : cars){
            car.stopEngine();
        }
    }
    void setTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOn();
            }
        }
    }
    void setTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOff();
            }
        }
    }
}