package org.example.wisesaying.entity;
import org.example.Container;
import org.example.Request;
import org.example.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    long lastWiseSayingId = 0;
    List<WiseSaying>wiseSayings = new ArrayList<>();
    public void write() {
        long id = lastWiseSayingId + 1;
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine().trim();
        System.out.printf("%d번 명언이 등록 되었습니다.\n", id);
        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayings.add(wiseSaying);
        lastWiseSayingId = id;
    }
    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }
    public void remove(Request request) {
        int id = request.getParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수) 값을 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        wiseSayings.remove(wiseSaying);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }
    public void modify(Request request) {
        int id = request.getParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수) 값을 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.printf("기존명언 : %s\n", wiseSaying.getContent());
        System.out.printf("명언 :");
        String content = Container.getSc().nextLine().trim();
        System.out.printf("기존작가 : %s\n", wiseSaying.getAuthor());
        System.out.printf("작가 :");
        String author = Container.getSc().nextLine().trim();
        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);
        System.out.println(id + "번 명언이 수정 되었습니다.");
    }
    private WiseSaying findById (int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id ) {
                return wiseSaying;
            }
        }
        return null;
    }
}