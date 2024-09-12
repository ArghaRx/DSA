import java.util.*;
class A
{
public static void main()
{
Scanner sc=new Scanner(System.in);
int n1,n2,n;
System.out.println("enter size: ");
int a[]=new int[n1]; 
int b[]=new int[n2];
System.out.println("enter all elements of matrix a: ");
for(int i=0;i<n1;i++)
{
a[i]=sc.nextInt();
}
System.out.println("enter all elements of matrix b: ");
for(i=0;i<n2;i++)
{
b[i]=sc.nextInt();
}
int c[]=new int[n];
for(int i=0;i<n;i++)
{
if(n1==n2)
{
c[i]=a[i]+b[i];
}
else
{
System.out.println("NOT POSSIBLE");
}
}
for(int i=0;i<n;i++)
{
System.out.println("Addition is:"+c[i]);
}
}
}