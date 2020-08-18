#include <stdio.h> 
#include <stdlib.h> 
#include <time.h> 
#include <windows.h> 

void online_friend (); 
int main ()
{
  printf ("比赛进行中。。。\n"); 
  online_friend ();
} 

void online_friend() 
{
  int a;
  Sleep(2000);
  printf("张三正在观看比赛，是否拍一拍(输入1)\n"); 
  scanf("%d",&a);
  Sleep(2000);
  if(a==1)
  {
    printf("你拍了拍张三的并通知他你也在观看\n");
  }
  return;
}
