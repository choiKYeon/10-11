package org.example.wisesaying.entity;

import org.example.Container;
import org.example.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    List<WiseSaying> wiseSayings = new ArrayList<>();
    long id = 1;
    public void write() {
        System.out.println("등록합니다");
        System.out.printf("명언 :");
        String content = Container.getSc().nextLine().trim();
        System.out.printf("작가 :");
        String author = Container.getSc().nextLine().trim();
        System.out.printf("%d번 명언이 종료되었습니다.", id);

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        id++;
    }
    public void list() {
        System.out.println("목록 출력합니다");
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor());
        }
    }
}
