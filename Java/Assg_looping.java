package Programs;

public class Assg_looping {
    Scanner_class sc4 = new Scanner_class();
    //sum of n nos
    public void sum_nos(){
        System.out.println("Enter the Natural Number: ");
        int n = sc4.sc.nextInt();
        int sum = 0;
        for (int i = 1;i<=n;i++)
        {
            sum = sum + i;
            // System.out.println(sum);
        }
        System.out.println("Sum of numbers: "+sum);
    }
    //Calculate the factorial
    public void factoial(){
        System.out.println("Enter the positive Number: ");
        int n = sc4.sc.nextInt();
        long fact = 1;
        for (int i = 1;i<=n;i++)
        {
            fact = fact * i;
            // System.out.println(sum);
        }
        System.out.println("Factorial of " + n +" numbers: "+ fact);
    }
    // Fibonacci series
    public void Fibonacci(){
        System.out.print("Enter how many terms you want in the series: ");
        int n = sc4.sc.nextInt();
        int a = 0, b = 1, c;
        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }
    //Reversing number
    public void reverse(){
        System.out.println("Enter the number to Reverse: ");
        int a = sc4.sc.nextInt();
        int rev = 0;
        while(a!=0)
        {
            int num = a%10; // get the last digit
            rev= rev * 10 + num; // add it to reversed number
            a = a/10; // remove the last digit
        }
        System.out.println("Reversed number: " + rev);
    }
    //Checking given number is Palindrome
    public void Palindrome(){
        System.out.println("Enter the number : ");
        int a = sc4.sc.nextInt();
        int rev = 0;
        int org = a;
        while(a!=0)
        {
            int num = a%10; // get the last digit
            rev= rev * 10 + num; // add it to reversed number
            a = a/10; // remove the last digit
        }
        //System.out.println("Reversed number: " + rev);
        if (org == rev){
            System.out.println("Given number is Palindrome");
        }
        else {
            System.out.println("Given number is Not Palindrome");
        }
    }
//counting the digits
    public void count(){
        System.out.println("Enter the numbers :");
        int num = sc4.sc.nextInt();
        int digit_count = String.valueOf(num).length();
        System.out.println("Total no of digits: "+digit_count);

    }
//Sum of Numbers
    public void sumofnos(){
        System.out.println("Enter the numbers :");
        int num = sc4.sc.nextInt();
        int digits=0;
        int temp = 0;
        while(num!=0){
                digits = num % 10; //getting last digit
                temp+=digits; //adding digit and stored in variable
                num=num/10; // deleting last digit
        }
        System.out.println(temp);
    }

    //Armstrong Number
    public void armstrong(){

        System.out.print("Enter a number: ");
        int num = sc4.sc.nextInt();
        int original = num;
        int sum = 0;
        int digits = String.valueOf(num).length(); // count number of digits

        while (num != 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits); // raise digit to power of number of digits
            num /= 10;
        }

        if (sum == original)
            System.out.println(original + " is an Armstrong number.");
        else
            System.out.println(original + " is NOT an Armstrong number.");
    }
// listing armstrong no
    public void armstrongnos(){
        System.out.print("Enter a upper limit number: ");
        int N = sc4.sc.nextInt();
        System.out.println("Armstrong numbers between 1 and " + N + " are:");

        for (int num = 1; num <= N; num++) {
            int sum = 0;
            int temp = num;
            int digits = String.valueOf(num).length();

            while (temp != 0) {
                int digit = temp % 10;
                sum += Math.pow(digit, digits);
                temp /= 10;
            }

            if (sum == num) {
                System.out.print(num + " ");
            }
        }
    }
    //finding n no of primenumbers
    public void prime_no(){
        System.out.println("Enter the Upper limit :");
        int a = sc4.sc.nextInt();
        for (int num = 2; num <= a; num++) {  // start from 2 (1 is not prime)
            boolean isPrime = true;

            // check divisibility from 2 to num/2
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }

    }
    //sum of n power 2
    public void sum_power(){
        System.out.println("Enter the n : ");
        int n = sc4.sc.nextInt();
        int sum =0;
        for(int i = 1; i<=n;i++)
        {
            sum+=Math.pow(i,2);
        }
        System.out.println("Sum of powers of "+ n + " :  " + sum);
    }
    public static void main(String[] args) {
        Assg_looping al = new Assg_looping();
        //al.factoial();
        //al.Fibonacci();
        //al.reverse();
        //al.Palindrome();
        //al.sum_nos();
        //al.count();
        //al.armstrong();
        //al.armstrongnos();
        //al.sumofnos();
        //al.prime_no();
        al.sum_power();
    }
}
