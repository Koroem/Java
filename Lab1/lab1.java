public class HelloWorld {
    // Condurat Victor 2E1
    public static void main(String[] args){
        System.out.print("HelloWorld!\n");
        String [] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        n*=3;

        String binaryString = "10101";
        int number = Integer.parseInt(binaryString, 2);
        n+=number;

        String hex = "FF";
        number=Integer.parseInt(hex, 16);
        n+=number;

        n*=6;

        int sum=0,sum2;
        while(n!=0)
        {
            sum+=n%10;
            n/=10;
        }
        while(sum>9)
        {
            sum2=0;
            while(sum!=0) {
                sum2+=sum%10;
                sum/=10;
            }
            sum=sum2;
        }
        
        System.out.print("Willy-nilly, this semester I will learn " + languages[sum]);

    }
}
