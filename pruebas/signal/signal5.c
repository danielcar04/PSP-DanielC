#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <time.h>
pid_t h1,h2;
int fd[2];
void salir(int signo)
{	
	exit(0);	
}
void handlepar(int signo)
{
int j;
read(fd[0], &j, sizeof(j));
printf("par recibe %d\n",j);
}
void handleimpar(int signo)
{
int j;
read(fd[0], &j, sizeof(j));
printf("impar recibe %d\n",j);
}
int main()
{
pipe(fd);
h1 = fork();
if(h1 == 0)
{
	signal(SIGUSR1,handlepar);
	signal(SIGUSR2,salir);
	while(1){
	sleep(1);
	}
}
else
{
h2 = fork();
	if(h2==0)
	{
	signal(SIGUSR1,handleimpar);
	signal(SIGUSR2,salir);
	while(1){
	sleep(1);
	}
	}
	else
	{
  int num;
  signal(SIGINT, salir);
  
  while(1){
	  printf("introduce un numero\n");
	  scanf("%d",&num);
	  write(fd[1],&num,sizeof(num));
	  if(num == 0){
	  printf("saliendo\n");
	  kill(h1,SIGUSR2);
	  kill(h2,SIGUSR2);
	  break;
	  }
	  if(num %2 == 0)
	  {
	  kill(h1,SIGUSR1);
	  }
	  else
	  {
	  kill(h2,SIGUSR1);
	  }
	 sleep(1);
  }
 return 0;
}
}
}
