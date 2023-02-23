import java.util.Scanner;



 class Tamagotchi {


    private static final int MAX_CYCLE = 8;

    private static final int HUNGRY_LEVEL = 3;

    private static final int BORED_LEVEL = 3;

    private static final String[] MOODS = {"Tout va bien !", "je m'ennuie à mourrir !", "je suis affamé !", "je suis affamé et je m'ennuie à mourrir !"};


    private static Tamagotchi[] pets;

    private String name;

    private int hunger;

    private int boredom;


    public Tamagotchi(String name) {

        this.name = name;

        hunger = 0;

        boredom = 0;

    }


    public String getName() {

        return name;

    }


    public boolean isAlive() {

        return hunger < HUNGRY_LEVEL && boredom < BORED_LEVEL;

    }


    public void play() {

        boredom--;

        System.out.println(name + " : \"On se marre !\"");

    }


    public void feed() {

        hunger--;

        System.out.println(name + " : \"Miam c'est bon !\"");

    }


    public void talk() {

        System.out.println(name + " : \"" + MOODS[getMoodIndex()] + "\"");

    }


    public void printMenu(int index) {

        System.out.print("(" + index + ") " + name + "          ");

    }


    public int getMoodIndex() {

        if (hunger >= HUNGRY_LEVEL && boredom >= BORED_LEVEL) {

            return 3;

        } else if (hunger >= HUNGRY_LEVEL) {

            return 2;

        } else if (boredom >= BORED_LEVEL) {

            return 1;

        } else {

            return 0;

        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de tamagoshis désiré : ");

        int numPets = scanner.nextInt();

        pets = new Tamagotchi[numPets];


        for (int i = 0; i < numPets; i++) {

            System.out.print("Entrez le nom du tamagoshi numéro " + i + " :  ");

            String name = scanner.next();

            pets[i] = new Tamagotchi(name);

        }


        for (int cycle = 1; cycle <= MAX_CYCLE; cycle++) {

            System.out.println("\n------------Cycle n°" + cycle + "-------------\n");

            for (int i = 0; i < numPets; i++) {

                pets[i].talk();

            }

            System.out.println("\nNourrir quel tamagoshi ?");

            for (int i = 0; i < numPets; i++) {

                pets[i].printMenu(i);

            }

            System.out.print("\nentrez un choix : ");

            int feedChoice = scanner.nextInt();

            pets[feedChoice].feed();


            System.out.println("\nJouer avec quel tamagoshi ?");

            for (int i = 0; i < numPets; i++) {

                pets[i].printMenu(i);

            }

            System.out.print("\nentrez un choix : ");

            int playChoice = scanner.nextInt();

            pets[playChoice].play();

        }


        System.out.println("\n------------Fin du jeu !-------------\n");

        for (int i = 0; i < numPets; i++) {

            pets[i].print();

        }

    }

    private void print() {
    }
}