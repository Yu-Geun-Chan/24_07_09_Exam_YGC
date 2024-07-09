package org.koreait;

public class App {

    public void run() {

        MotivationController motivationController = new MotivationController();
        SystemController systemController = new SystemController();

        System.out.println("== 명언 앱 실행 ==");

        while (true) {
            System.out.print("명령어 ) ");
            String cmd = Contaniner.getScanner().nextLine().trim();

            if (cmd.isEmpty()) {
                System.out.println("명령어를 입력하세요.");
                continue;
            }

            if (cmd.equals("종료")) {
                systemController.exit();
                break;
            } else if (cmd.equals("등록")) {
                motivationController.doWrite();
            } else if (cmd.startsWith("목록")) {
                motivationController.showList();
            } else if (cmd.startsWith("상세보기")) {
                motivationController.showDetail(cmd);
            } else if (cmd.startsWith("수정")) {
                motivationController.doModify(cmd);
            } else if (cmd.startsWith("삭제")) {
                motivationController.doDelete(cmd);
            } else System.out.println("올바르지 않은 명령어입니다.");
        }
    }
}
