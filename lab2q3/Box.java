package Lab2;
import java.util.ArrayList;
import java.util.Scanner;
public class Box {
public static int width, height;
private int i,j,x,y;

public static Box getInstance(){
    Box b = new Box(7,10);
    return b;
}

private Box(int WIDTH, int HEIGHT){
    width = WIDTH;
    height = HEIGHT;
}

public void printbox() {
    String[][] thebox = new String[width][height];
    for (i = 0; i < width; i++) {
        for (j = 0; j < height; j++) {
            if (j == 0) {
                thebox[i][j] = "|";
            } else if (j == height - 1) {
                thebox[i][j] = "|\n";
            } else {
                if (i == 0 || i == width - 1)
                    thebox[i][j] = "=";
                else
                    thebox[i][j] = " ";
            }
        }
    }

    Particles p = new Particles();
    ArrayList<Integer> partLocaX = p.createParticleX(10);
    ArrayList<Integer> partLocaY = p.createParticleY(10);

    Scanner keyboard = new Scanner(System.in);
    boolean exit = false;
    while (!exit)
    {
        System.out.println("Type \"cont\" to initialize the box:  ");
        String input =  keyboard.nextLine();
        if (input != null) {
            if ("cont".equals(input))
            {
                while ("cont".equals(input)) {
                    int counter = partLocaX.size(); 
                    if (counter < (width - 2) * (height - 2)) 
                    {

                        for (int g = 0; g < partLocaX.size(); g++) {
                            int moveX = getRandom.Random(-1, 1);
                            int locaX = partLocaX.get(g); 
                            int moveY = getRandom.Random(-1, 1);
                            int locaY = partLocaY.get(g); 
                            if (locaX == 1)
                                moveX = getRandom.Random(0, 1);
                            else if (locaX == width - 2)
                                moveX = getRandom.Random(-1, 0);
                            partLocaX.set(g, partLocaX.get(g) + moveX);
                            if (locaY == 1)
                                moveY = getRandom.Random(0, 1);
                            else if (locaY == height - 2)
                                moveY = getRandom.Random(-1, 0);
                            partLocaY.set(g, partLocaY.get(g) + moveY);
                        }
                        for (int i = 0; i < partLocaX.size(); i++) {
                            for (int j = i + 1; j < partLocaX.size(); j++) {
                                if (partLocaX.get(i).equals(partLocaX.get(j))) {
                                    if (partLocaY.get(i).equals(partLocaY.get(j))) {
                                        partLocaX.add(getRandom.Random(1, width - 2));
                                        partLocaY.add(getRandom.Random(1, height - 2));
                                        counter++;
                                    }
                                }
                            }
                        }


                       
                        for (int k = 0; k < partLocaX.size(); k++) {
                            x = partLocaX.get(k);
                            y = partLocaY.get(k);
                            thebox[x][y] = "o";
                        }

                       
                        System.out.println("Num of parts: " + counter);
                        for (i = 0; i < width; i++) {
                            for (j = 0; j < height; j++) {
                                System.out.print(thebox[i][j]);
                            }
                        }

                    
                        for (int k = 0; k < partLocaX.size(); k++) {
                            x = partLocaX.get(k);
                            y = partLocaY.get(k);
                            thebox[x][y] = " ";
                        }

                        System.out.println("Type \"cont\" to continue the code, \"quit\" to exit code:  ");
                        input = keyboard.nextLine();
                        if ("quit".equals(input)) { 
                            System.out.println("Exit program");
                            exit = true;
                        }
                    }
                    else {
                        System.out.print("Maximum particles reached. The system goes UwU");
                        exit = true;
                        break;
                    }
                }
            }
        }
}

}

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

}


