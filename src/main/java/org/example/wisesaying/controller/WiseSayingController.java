package org.example.wisesaying.controller;

import org.example.Container;
import org.example.Request;
import org.example.wisesaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    long wisesayinglastid = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    public void write(){
        long id = wisesayinglastid + 1;

        System.out.println("명언을 등록합니다.");
        System.out.print("명언 :");
        String content = Container.getsc().nextLine().trim();
        System.out.print("작가 :");
        String author = Container.getsc().nextLine().trim();
        System.out.println(id + "번 명언이 등록되었습니다.");

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        wisesayinglastid++;
    }
    public void list(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(17));
        for (int i = wiseSayings.size() - 1; i >= 0; i--){
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }
    public void remove(Request request){
        int id = request.getIntParams("id", -1);
        if (id == -1){
            System.out.println("정수 id값을 입력해주세요.");
            return;
        }
        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null){
            System.out.println(id + "번 명언이 존재하지 않습니다.");
            return;
        }

        wiseSayings.remove(wiseSaying);

        System.out.println(id + "번 목록이 삭제되었습니다.");
    }
    public void modify(Request request){
        int id = request.getIntParams("id", -1);
        if (id == -1){
            System.out.println("정수 id값을 입력해주세요.");
            return;
        }
        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null){
            System.out.println(id + "번 명언이 존재하지 않습니다.");
            return;
        }
        System.out.printf("기존 명언 : %s\n", wiseSaying.getContent());
        System.out.printf("명언 : ");
        String content = Container.getsc().nextLine().trim();
        System.out.printf("기존 작가 : %s\n", wiseSaying.getAuthor());
        System.out.printf("작가 : ");
        String author = Container.getsc().nextLine().trim();

        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);
        System.out.printf(id + "번 목록이 수정되었습니다.");
    }

    private WiseSaying findById(int id){
        for (WiseSaying wiseSaying : wiseSayings){
            if (wiseSaying.getId() == id){
                return wiseSaying;
            }
        }
        return null;
    }
}
