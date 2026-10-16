import java.util.Scanner;

public class RoverMission {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 初始狀態：起始 20 格能源、0 份樣本、0 次行動
        int energy = 20;
        int samples = 0;
        int actionCount = 0;
        boolean running = true;

        System.out.println("=== 火星探測車任務開始 ===");
        System.out.println("初始能源：" + energy + " | 初始樣本：" + samples);

        // while 迴圈：仍在執行、仍有能源、尚未達到 5 份樣本時繼續
        while (running && energy > 0 && samples < 5) {
            System.out.println("\n請選擇行動 (1:探索[-6/+2] 2:掃描[-2/+1] 3:充電[+5] 0:返回)：");
            if (!input.hasNextInt()) {
                break;
            }
            int command = input.nextInt();

            switch (command) {
                case 1:
                    // TODO D1：探索 (耗 6 能源，加 2 樣本)
                    if (energy >= 6) {
                        energy -= 6;
                        samples += 2;
                        actionCount++;
                        System.out.println("-> 執行探索：能源 -6，樣本 +2");
                    } else {
                        System.out.println("-> 能源不足，無法探索！");
                    }
                    break;

                case 2:
                    // TODO D2：掃描 (耗 2 能源，加 1 樣本)
                    if (energy >= 2) {
                        energy -= 2;
                        samples += 1;
                        actionCount++;
                        System.out.println("-> 執行掃描：能源 -2，樣本 +1");
                    } else {
                        System.out.println("-> 能源不足，無法掃描！");
                    }
                    break;

                case 3:
                    // TODO D3：充電 (加 5 能源，上限 20)
                    if (energy < 20) {
                        energy += 5;
                        if (energy > 20) {
                            energy = 20;
                        }
                        actionCount++;
                        System.out.println("-> 執行充電：能源 +5 (上限 20)");
                    } else {
                        System.out.println("-> 已達滿電上限，無法充電！");
                    }
                    break;

                case 0:
                    // 返回指令
                    running = false;
                    System.out.println("-> 收到返回指令，結束任務。");
                    break;

                default:
                    System.out.println("-> 無效的指令！");
                    break;
            }

            // 印出每輪更新後的狀態
            System.out.println("當前能源：" + energy + " | 當前樣本：" + samples + " | 有效行動數：" + actionCount);
        }

        // 任務結束判定（成功優先）
        System.out.println("\n=== 任務結束總結 ===");
        if (samples >= 5) {
            System.out.println("任務結果：SUCCESS (成功採集 5 份以上樣本！)");
        } else if (energy == 0) {
            System.out.println("任務結果：EXHAUSTED (能源耗盡！)");
        } else {
            System.out.println("任務結果：RETURNED (主動返回機庫)");
        }
        System.out.println("最終能源：" + energy + " | 最終樣本：" + samples + " | 總有效行動次數：" + actionCount);

        input.close();
    }
}
    

