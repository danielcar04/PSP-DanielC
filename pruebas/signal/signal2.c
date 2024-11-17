#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <time.h>
int tiempo = 5;
/* Función para gestión de señales*/
void sig_handler(int signo)
{	if (signo == SIGINT){
	exit(0);	
	}
}
void alarma( int a)
{
if(a == SIGALRM){
printf("han pasado %d segundos\n", tiempo);
}
}
int main()
{
  signal(SIGINT, sig_handler);
  signal(SIGALRM,alarma);
  while(1){
  alarm(5);
  pause();
  tiempo = tiempo + 5;
  }
 return 0;
}
