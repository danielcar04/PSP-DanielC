#include<stdio.h>
#include<signal.h>
#include<unistd.h>
#include <time.h>
#include <stdlib.h>
int tiempo2 = 0;
//Función de manejo de la señal
void sig_handler(int signo)
{	if (signo == SIGINT){
	exit(0);	
	}
}

void sig_tiempo(int tiempo)
{
if (tiempo == SIGALRM)
tiempo2 = tiempo2 + 5;
printf("han pasado %d segundos \n",tiempo2);
}

int main(void)
{

signal(SIGINT, sig_handler); //para pararlo sin usar el kill  
signal(SIGALRM,sig_tiempo);
  while(1) {
    alarm(5);
    pause();
  }
  return 0;
}
