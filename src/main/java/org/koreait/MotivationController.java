package org.koreait;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MotivationController {
    private int lastId;
    List<Motivation> motivations;

    MotivationController() {
        lastId = 0;
        motivations = new ArrayList<>();
    }

    public void doWrite() {

        int id = lastId + 1;
        System.out.print("명언 : ");
        String body = Contaniner.getScanner().nextLine();
        System.out.print("작가 : ");
        String author = Contaniner.getScanner().nextLine();
        String regDate = Util.getNow();
        String updateDate = regDate;

        Motivation motivation = new Motivation(id, regDate, updateDate, body, author);

        motivations.add(motivation);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        lastId++;
    }

    public void showList() {
        System.out.println("번호   /    작가    /    명언    ");
        System.out.println("=".repeat(40));

        if (motivations.isEmpty()) {
            return;
        }

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);
            System.out.printf("%d   /    %s    /     %s     \n", motivation.getId(), motivation.getAuthor(), motivation.getBody());
        }
    }

    public void showDetail (String cmd) {
        String[] cmdBits = cmd.split("=");

        int id;

        try {
            id = Integer.parseInt(cmdBits[1]);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }

        Motivation foundMotivation = null;

        for (Motivation motivation : motivations) {
            if (id == motivation.getId()) {
                foundMotivation = motivation;
                break;
            }
        }

        if (foundMotivation == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("번호 : %d\n", foundMotivation.getId());
        System.out.printf("날짜 : %s\n", foundMotivation.getUpdateDate());
        System.out.printf("작가 : %s\n", foundMotivation.getAuthor());
        System.out.printf("내용 : %s\n", foundMotivation.getBody());

    }
    public void doModify(String cmd) {
        String[] cmdBits = cmd.split("=");

        int id;

        try {
            id = Integer.parseInt(cmdBits[1]);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }

        Motivation foundMotivation = null;

        for (Motivation motivation : motivations) {
            if (id == motivation.getId()) {
                foundMotivation = motivation;
                break;
            }
        }

        if (foundMotivation == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) :%s\n", foundMotivation.getBody());
        System.out.printf("작가(기존) :%s\n", foundMotivation.getAuthor());
        System.out.print("명언 : ");
        String newBody = Contaniner.getScanner().nextLine();
        System.out.print("작가 : ");
        String newAuthor = Contaniner.getScanner().nextLine();

        foundMotivation.setBody(newBody);
        foundMotivation.setAuthor(newAuthor);
        foundMotivation.setUpdateDate(Util.getNow());

        System.out.printf("%d번 명언이 수정되었습니다.\n", foundMotivation.getId());
    }

    public void doDelete(String cmd) {

        String[] cmdBits = cmd.split("=");

        int id;

        try {
            id = Integer.parseInt(cmdBits[1]);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }

        Motivation foundMotivation = null;

        for (Motivation motivation : motivations) {
            if (id == motivation.getId()) {
                foundMotivation = motivation;
                break;
            }
        }

        if (foundMotivation == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        motivations.remove(foundMotivation);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", foundMotivation.getId());
    }
}
