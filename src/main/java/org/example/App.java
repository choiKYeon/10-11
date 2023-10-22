package org.example;

import org.example.system.controller.SystemController;
import org.example.wisesaying.controller.WiseSayingController;
import org.example.wisesaying.entity.WiseSaying;

public class App {
    public void run() {
        WiseSayingController wiseSayingController = new WiseSayingController();
        SystemController systemController = new SystemController();
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령)");
            String answer = Container.getsc().nextLine().trim();
            Request request = new Request(answer);

            switch (request.getActioncode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(request);
                    break;
                case "수정":
                    wiseSayingController.modify(request);
                    break;
            }
        }
    }
}