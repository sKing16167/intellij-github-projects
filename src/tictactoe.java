import java.util.Scanner;
public class tictactoe {
    public static void main(String[] args) {
        String[][] tictac;
        tictac = new String[3][3];

        tictac[0][0] = "1";
        tictac[0][1] = "2";
        tictac[0][2] = "3";
        tictac[1][0] = "4";
        tictac[1][1] = "5";
        tictac[1][2] = "6";
        tictac[2][0] = "7";
        tictac[2][1] = "8";
        tictac[2][2] = "9";
        Scanner sc = new Scanner(System.in);
        int choice;
        char continuegame;




        for (int i = 0; i < tictac.length; i++) {
            for (int j = 0; j < tictac[i].length; j++) {
                System.out.print('|');

                System.out.print(tictac[i][j]);
                System.out.print("|");
            }
            System.out.println("");
        }
        for (int k = 0; k < 9; k++) {


            System.out.println("plz choose the box to place your icon");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    choice = 1;
                    System.out.println("plz place X OR O");
                    tictac[0][0] = sc.next();

                    for (int i = 0; i < tictac.length; i++) {
                        for (int j = 0; j < tictac[i].length; j++) {
                            System.out.print('|');

                            System.out.print(tictac[i][j]);
                            System.out.print("|");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    choice = 2;
                    System.out.println("plz place X OR O");
                    tictac[0][1] = sc.next();

                    for (int i = 0; i < tictac.length; i++) {
                        for (int j = 0; j < tictac[i].length; j++) {
                            System.out.print('|');

                            System.out.print(tictac[i][j]);
                            System.out.print("|");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    choice = 3;
                    System.out.println("plz place X OR O");
                    tictac[0][2] = sc.next();


                    for (int i = 0; i < tictac.length; i++) {
                        for (int j = 0; j < tictac[i].length; j++) {
                            System.out.print('|');

                            System.out.print(tictac[i][j]);
                            System.out.print("|");
                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    choice = 4;
                    System.out.println("plz place X OR O");
                    tictac[1][0] = sc.next();

                    for (int i = 0; i < tictac.length; i++) {
                        for (int j = 0; j < tictac[i].length; j++) {
                            System.out.print('|');

                            System.out.print(tictac[i][j]);
                            System.out.print("|");
                        }
                        System.out.println("");
                    }
                    break;
                case 5:
                    choice = 5;
                    System.out.println("plz place X OR O");
                    tictac[1][1] = sc.next();

                    for (int i = 0; i < tictac.length; i++) {
                        for (int j = 0; j < tictac[i].length; j++) {
                            System.out.print('|');

                            System.out.print(tictac[i][j]);
                            System.out.print("|");
                        }
                        System.out.println("");
                    }
                    break;
                case 6:
                    choice = 6;
                    System.out.println("plz place X OR O");
                    tictac[1][2] = sc.next();

                    for (int i = 0; i < tictac.length; i++) {
                        for (int j = 0; j < tictac[i].length; j++) {
                            System.out.print('|');

                            System.out.print(tictac[i][j]);
                            System.out.print("|");
                        }
                        System.out.println("");
                    }
                    break;
                case 7:
                    choice = 7;
                    System.out.println("plz place X OR O");
                    tictac[2][0] = sc.next();

                    for (int i = 0; i < tictac.length; i++) {
                        for (int j = 0; j < tictac[i].length; j++) {
                            System.out.print('|');

                            System.out.print(tictac[i][j]);
                            System.out.print("|");
                        }
                        System.out.println("");
                    }
                    break;
                case 8:
                    choice = 8;
                    System.out.println("plz place X OR O");
                    tictac[2][1] = sc.next();

                    for (int i = 0; i < tictac.length; i++) {
                        for (int j = 0; j < tictac[i].length; j++) {
                            System.out.print('|');

                            System.out.print(tictac[i][j]);
                            System.out.print("|");
                        }
                        System.out.println("");
                    }
                    break;
                case 9:
                    choice = 9;
                    System.out.println("plz place X OR O");
                    tictac[2][2] = sc.next();

                    for (int i = 0; i < tictac.length; i++) {
                        for (int j = 0; j < tictac[i].length; j++) {
                            System.out.print('|');

                            System.out.print(tictac[i][j]);
                            System.out.print("|");
                        }
                        System.out.println("");
                    }
                    break;


            }


            if ((tictac[0][0].equals(tictac[0][1])) && (tictac[0][1].equals(tictac[0][2]))) {
                System.out.println("winner is :" + tictac[0][0]);
                break;
            } else if ((tictac[1][0].equals(tictac[1][1])) && (tictac[1][1].equals(tictac[1][2]))) {
                System.out.println("winner is :" + tictac[1][0]);
                break;
            } else if ((tictac[2][0].equals(tictac[2][1])) && (tictac[2][1].equals(tictac[2][2]))) {
                System.out.println("winner is :" + tictac[2][0]);
                break;
            } else if ((tictac[0][0].equals(tictac[1][0])) && (tictac[1][0].equals(tictac[2][0]))) {
                System.out.println("winner is :" + tictac[0][0]);
                break;
            } else if ((tictac[0][1].equals(tictac[1][1])) && (tictac[1][1].equals(tictac[2][1]))) {
                System.out.println("winner is :" + tictac[0][1]);
                break;
            } else if ((tictac[0][2].equals(tictac[1][2])) && (tictac[1][2].equals(tictac[2][2]))) {
                System.out.println("winner is :" + tictac[0][2]);
                break;
            } else if ((tictac[0][0].equals(tictac[1][1])) && (tictac[1][1].equals(tictac[2][2]))) {
                System.out.println("winner is :" + tictac[0][0]);
                break;
            } else if ((tictac[0][2].equals(tictac[1][1])) && (tictac[1][1].equals(tictac[2][0]))) {
                System.out.println("winner is :" + tictac[0][2]);
                break;
            } else if (k==8) {
                System.out.println("It's a draw!");

            }



        }
        


    }
}





