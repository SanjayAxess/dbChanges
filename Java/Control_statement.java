package Programs;

public class Control_statement {
    Scanner_class sc3 = new Scanner_class();
    //Even or Odd
    public void even_odd(){
        System.out.println("Enter the Number:");
        int a = sc3.sc.nextInt();
        if (a%2 == 0)
        {
            System.out.println("Given number is Even: " + a);
        }
        else {
            System.out.println("Given Number is Odd: " + a);
        }
    }
    //Positive or Negative or Zero
    public void pos_neg()
    {
        System.out.println("Enter the NUmber :");
        int a = sc3.sc.nextInt();
        if (a>=1)
        {
            System.out.println("The given number is Positive: " + a);
        } else if (a<0) {
            System.out.println("The given number is Negative: "+a);
        }
        else {
            System.out.println("The Given number is Zero: "+a);
        }
    }
    //largest of 3 nos
    public void larg(){
        System.out.println("Enter the first no:");
        int a = sc3.sc.nextInt();
        System.out.println("Enter the second no:");
        int b = sc3.sc.nextInt();
        System.out.println("Enter the Third no:");
        int c = sc3.sc.nextInt();
        int d = (c >b)?((c >c)? c :c):((b>c)?b:c);
        System.out.println("Greater NO: "+d);
    }
    //Leap Year
    public void leap_year() {
        System.out.println("Enter the year:");
        int a = sc3.sc.nextInt();
        if (a % 4 == 0) {
            System.out.println(a + " Year is Leap Year");
        } else {
            System.out.println(a + " Not a leap year");
        }
    }
    //Grade Calculator
    public void grade_cal(){
        System.out.println("Enter the Mark:");
        int mark = sc3.sc.nextInt();
        switch (mark/10){
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            case 5:
                System.out.println("E");
                break;
            default:
                System.out.println("Fail");
        }
    }
    //sum of n nos
    public void sum_nos(){
        System.out.println("Enter the Natural Number: ");
        int n = sc3.sc.nextInt();
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
        int n = sc3.sc.nextInt();
        long fact = 1;
        for (int i = 1;i<=n;i++)
        {
            fact = fact * i;
            // System.out.println(sum);
        }
        System.out.println("Factorial of " + n +" numbers: "+ fact);
    }
    //Multiplication table
    public void multiplication(){
        System.out.println("Enter the table number: ");
        int a = sc3.sc.nextInt();
        for (int i =0; i <= 10; i++)
        {
            int j = 0;
            j = i * a;
            System.out.println(i + " * " + a + " = " + j);

        }
    }
    // Fibonacci series
    public void Fibonacci(){
        System.out.print("Enter how many terms you want in the series: ");
        int n = sc3.sc.nextInt();
        int a = 0, b = 1, c;
        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }
    //Checking given is prime Number or not
    public void prime_check() {
        System.out.print("Enter the number: ");
        int n = sc3.sc.nextInt();
        boolean check = true;
        if (n <= 1) {
            check = false; // 0 and 1 are not prime
        } else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
               }
            }
        }
        if (check){
            System.out.println(n + " is prime number");
        }
        else {
            System.out.println(n + " is not a prime number");
        }
    }
//Reversing number
    public void reverse(){
        System.out.println("Enter the number to Reverse: ");
        int a = sc3.sc.nextInt();
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
        int a = sc3.sc.nextInt();
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

    public static void main(String[] args) {
        Control_statement cs = new Control_statement();
        //cs.even_odd();
        //cs.pos_neg();
        //cs.larg();
        //cs.leap_year();
        //cs.grade_cal();
        //cs.sum_nos();
        //cs.factoial();
        //cs.multiplication();
        //cs.Fibonacci();
        //cs.prime_check();
        //cs.reverse();
        cs.Palindrome();
    }

}
