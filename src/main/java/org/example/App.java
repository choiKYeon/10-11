package org.example;

import org.example.system.SystemController;
import org.example.wisesaying.entity.WiseSayingController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        System.out.println("== 입력 ==");

        while (true) {
            System.out.printf("명령)");
            String answer = Container.getSc().nextLine().trim();

            if (answer.equals("종료")) {
                systemController.exit();
                break;
            } else if (answer.equals("등록")) {
                wiseSayingController.write();
            } else if (answer.equals("목록")) {
                wiseSayingController.list();
            }
        }
    }
}
