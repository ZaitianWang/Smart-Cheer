#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
void online_friend();
int main(){
	printf("���������С�����\n");
    online_friend();

}
void online_friend()
{

    int a;
    Sleep(2000);
    printf("�������ڹۿ��������Ƿ���һ��(����1)\n"); 
    scanf("%d",&a);
    Sleep(2000);
    if(a==1)
    {
        printf("�������������Ĳ�֪ͨ����Ҳ�ڹۿ�\n");
    }
    return;

}
