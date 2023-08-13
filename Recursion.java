import java.util.*;
import java.util.stream.Collectors;

public class Recursion1 {


//    static void fun1(int a){
//        if(a>0) {
//            System.out.print(a + " ");
//            fun1(a - 1);
//        }
//    }
//    static void fun2(int a){
//        if(a>0) {
//            fun2(a - 1);
//            System.out.print(a + " ");
//        }
//    }

//    static void f1()
    static int fact(int n){
        if(n==0){
            return 1;
        } else{
            return fact(n-1)*n;
        }
    }

    static int loopfact(int n){
        int f =1;
        int i =0;
        for(i=1;i<=n;i++){
            f =f*i;
        }
        return f;
    }

    static int power(int m, int n){
        if(n==0)
            return 1;
        else
            return power(m,n-1)*m;
    }

    static int power1(int m, int n){
        if(n==0)
            return 1;
        if(n%2==0)
            return power1(m*m,n/2);
        else
            return m*power1(m*m,(n-1)/2);
    }

    //Taylor Series
    static double exp(int x, int n){
        double p=1,f=1;
        double r;

        if(n==0)
            return 1;
        else
            r=exp(x,n-1);
        p=p*x;
        f=f*n;
        return r+p/f;


    }

    //Fib series
    public static int fib(int n){
        int t0=0,t1=1,s=0,i;
        if(n<=0)
            return n;

        for(i=2;i<=n;i++){
            s=t0+t1;
            t0=t1;
            t1=s;
        }
        return s;
    }

    //Recursive Fibonacci
    public static int rFib(int n){
        if(n<=1)
            return n;
        else
            return rFib(n-2)+rFib(n-1);
    }

    //Memo Fib
    static int F[] =new int[10];
    public static int mFib(int n){

        if(n<=1){
            F[n] =n;
            return n;
        }else{
            if(F[n-2] ==-1)
                F[n-2] =mFib(n-2);
            if(F[n-1] ==-1)
                F[n-1] =mFib(n-1);
            F[n] =F[n-2] + F[n-1];
            return F[n-2] + F[n-1];
        }
    }

    //Combination Formula..
    static int nCr(int n,int r){
        int num =fact(n);
        int den =fact(r)*fact(n-r);

        return num/den;
    }

    static int NCR(int n, int r){
        if(n==r || r==0)
            return 1;
        else
            return NCR(n-1,r-1)+NCR(n-1,r);
    }

    //TOH
    static void TOH(int n, int A, int B, int C){
        if(n>0){
            TOH(n-1,A,B,C);
            System.out.println("Source - Destination : "+A +"-"+C);
            TOH(n-1,B,A,C);
        }
    }
    public static void main(String[] args) {
    //        int i =3;
    //        System.out.println("----By Fun1");
    //        fun1(i);
    //
    //        System.out.println("\n----By Fun2");
    //        fun2(i);
        int r;
        r=loopfact(4);
        System.out.println("LoopFact: "+r);

        int p;
        p=power(2,9);
        System.out.println("Power: "+p);

        int q;
        q=power1(2,9);
        System.out.println("Power1: "+q);

        double t;
        t=exp(2,2);
        System.out.println("Exponential: "+t);

        System.out.println("Fibonacci : "+fib(9));

        System.out.println("Recursive Fibonacci : "+rFib(9));

        for(int i=0;i<10;i++){
            F[i]= -1;
        }
        System.out.println("Memo Fibonacci : "+mFib(9));
        Arrays.stream(F).forEach(System.out::print);

        System.out.println("\nCombination nCr: "+nCr(6,2));

        System.out.println("Combination NCR: "+NCR(6,2));


        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> shortedList =
                list.stream()
                        //.filter(i -> i%2==0)
                        //.map(i->i+10)
                        .reduce(new ArrayList<Integer>(),(a,b)->{
                            if(b%2==0)
                                a.add(b);
                            return a;
                        },(a,b)->{
                            a.addAll(b);
                            return a;
                        });
                        //.collect(Collectors.toSet());
        System.out.println("Sorted Data: "+shortedList);

        TOH(3,1,2,3);
    }
}
