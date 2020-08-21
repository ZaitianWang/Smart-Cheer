#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
	sing();
	while(full_time==0)
	{
		void volume();
		void comments();
	}
	return 0;
}


void sing()     //function to control the cheering songs
{
    while(full_time==0)     //game not end
    {
    	sing=0;     //mute
    	sleep(600000);
    	sing=1;     //sing
    	if(end_of_song==1)
    	sing=0;
	}
}

void volume(int num_comments)   //to control the volume
{
	int volume;
	ave=get_ave_of_comments();
	volume = 100*(num/ave);
}

void contents()     //decide which comment will be played as mass cheer
{
	char *comment;
	int play;
	FILE *fopen( const char * comments.txt, const char * r );   //read a txt
	comment[]=get_comments();
	if(comment_known)       //a certain comment is in the txt
	{
		play=1;             //then this comment will be played as cheer
	}
}
