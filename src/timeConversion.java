public class timeConversion {

    public static void main(String[] args){
        // testing time conversion using modulus and divison
        int seconds = 1500;
        int minutes = seconds % 3600 /60;
        int s2 = seconds % 3600 % 60;
        System.out.println(minutes + " " + s2);
    }
}
