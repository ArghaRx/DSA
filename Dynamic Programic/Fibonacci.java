/*


//  Normal Recursive Approach

// TC = O(N)  SC = O(N + N)

import java.util.*;
class A{
public static void main(String args[]){
int n;
Scanner sc = new Scanner(System.in);
System.out.println("Enter the value of N: ");
n = sc.nextInt();
System.out.println("Nth fibbonaci value is: "+fun(n));
}

public static int fun(int n)
{
if(n <= 1) return n;
return fun(n -1) + fun(n -2);
}
}


*/


/*


//Memoization

// TC = O(N)  SC = O(N + N)


import java.util.*;
class A{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
int n;
System.out.println("Enter the value of N: ");
n = sc.nextInt();
int dp[] = new int[n + 1];
Arrays.fill(dp, -1);
System.out.println("Nth fibbonaci value is: "+fun(n, dp));
}

public static int fun(int n, int dp[])
{
if(n <= 1) return n;

if(dp[n] != -1) return dp[n];   //if same value repeats

return dp[n] = fun(n - 1, dp) + fun(n - 2, dp);  // store the value
}
}


*/
/*




// Tabulation

// TC = O(N)  SC = O(N) ; NO need any recursive stack space , only dp array



import java.util.*;
class A{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
int n;
System.out.println("Enter the value of N: ");
n = sc.nextInt();
int dp[] = new int[n + 1];
Arrays.fill(dp, -1);

// Without recursion but Base case approach
dp[0] = 0;
dp[1] = 1;

for(int i = 2; i <= n; i++)
{
dp[i] = dp[i - 1] + dp[i - 2];
}

System.out.println("Nth fibonacci no is: "+ dp[n]);
}
}


*/



// Space Optimization

// TC = O(N)  SC = O(1)


import java.util.*;
class B{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
int n;
System.out.println("Enter the value of N: ");
n = sc.nextInt();

// No dp array

// Without recursion but Base case approach
 
int prev2 = 0;
int prev = 1;
int ans = 0;

for(int i = 2; i <= n; i++)
{
ans = prev2 + prev;
prev2 = prev;
prev = ans;
}

System.out.println("Nth fibonacci no is: "+ ans);
}
}


