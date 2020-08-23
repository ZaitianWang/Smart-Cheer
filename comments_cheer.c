#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define N 3
struct Outcome
{
	int chosen_comment_index;
	int vol_degree; 
};
void displayer();
int max_portion(int *count);
void processor(char comment[][8], struct Outcome* out);
void cheer(struct Outcome* out);

int main()  
{
	/*situations randomly take place*/
	displayer();
	
    /* Your comments*/
	char comment[N][8];
	int i;
	for(i=0;i<N;i++)
		gets(comment[i]);
		
	struct Outcome out;
	processor(comment, &out);
    cheer(&out);
}
void displayer()
{
    int x;
    time_t t;   
    srand((unsigned) time(&t));
    x=rand() % 3+1;
    
	if(x==1){
		printf("We scored!\n");
	} 
	else if(x==2){
		printf("We are attacking!\n");
	} 
	else if(x==3){
		printf("Opponents are attacking!\n");
	}
	else {
		printf("Opponents missed!\n");
	} 
}
void processor(char comment[][8], struct Outcome* out)
{
	/* repository of comments*/
    char com_known[4][8]={"nb","bravo","defence","boo"};
	/* count which comment you post is most, 
	the comment has to be matched in the repository of comments 
	due to limited skill*/
	int count[4],i;
	for(i=0;i<4;i++)
	    count[i]=0;
	    
	for(i=0;i<N;i++)
		{
			if(strcmp(comment[i],com_known[0])==0)count[0]++;
			else if(strcmp(comment[i],com_known[1])==0)count[1]++;	
			else if(strcmp(comment[i],com_known[2])==0)count[2]++;
			else if(strcmp(comment[i],com_known[3])==0)count[3]++;			    
		}
	int result;
	result=max_portion(count);
    out->vol_degree=count[result];
    out->chosen_comment_index=result;
}
int max_portion(int *count)
{
	int i, index=0,max=*count;
	 for(i=0; i<4; i++)
        {
            if(count[i]>max)
            {
                max=count[i];
                index=i;
            }
        }
    return index;
}
void cheer(struct Outcome* out)
{
	char com_known[4][8]={"nb","bravo","defence","boo"};
	if(out->vol_degree==N){
		printf("%s explode!\n",com_known[out->chosen_comment_index]);
	}
	else{
		printf("%s is so high!\n",com_known[out->chosen_comment_index]);
	}	   	
}

