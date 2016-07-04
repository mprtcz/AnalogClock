package com.azotan.clock;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

import java.util.Date;

/**
 * Created by Azet on 2015-12-05.
 */
public class AppController {

    public Line secondsLine, minutesLine, hoursLine;
    public Button button;
    int hour, minute, second;

    public void buttonClicked(ActionEvent event) throws InterruptedException {

        button.setDisable(true);

        Task task = new Task<Void>() {

            Rotate rotSec = new Rotate(0, secondsLine.getEndX(), 0, 0, Rotate.Z_AXIS);
            Rotate rotMin = new Rotate(0, minutesLine.getEndX(), 0, 0, Rotate.Z_AXIS);
            Rotate rotHr = new Rotate(0, hoursLine.getEndX(), 0, 0, Rotate.Z_AXIS);
            Date d = new Date();

            @Override
            public Void call() throws Exception {
                System.out.println("Started...");
                while(true) {
                    Platform.runLater(() -> {

                        d.setTime(System.currentTimeMillis());
                        hour = d.getHours();
                        minute = d.getMinutes();
                        second = d.getSeconds();

                        rotSec.setAngle(0);
                        rotMin.setAngle(0);
                        rotHr.setAngle(0);

                        rotSec.setAngle(6*second);
                        rotMin.setAngle(6*minute);
                        rotHr.setAngle(30*hour + 0.5*minute);

                        secondsLine.getTransforms().clear();
                        minutesLine.getTransforms().clear();
                        hoursLine.getTransforms().clear();

                        secondsLine.getTransforms().add(rotSec);
                        minutesLine.getTransforms().add(rotMin);
                        hoursLine.getTransforms().add(rotHr);
                    });
                    Thread.sleep(100);
                }
            }
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        System.out.println(Platform.isFxApplicationThread());
    }
}
