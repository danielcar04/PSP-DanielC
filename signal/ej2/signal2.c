#include<stdio.h>
#include<signal.h>
#include<unistd.h>
#include <time.h>
#include <stdlib.h>

//Función de manejo de la señal
void sig_handler(int signo)
{	if (signo == SIGINT){
	exit(0);	
	}
}

void sig_tiempo(int tiempo)
{

printf("han pasado ");
}

int main(void)
{
int tiempo = 0;
signal(SIGINT, sig_handler); //para pararlo sin usar el kill  
signal(SIGALRM,sig_tiempo);
  while(1) {
    alarm(5);
    pause();
        tiempo = tiempo + 5;
    printf("%d segundos \n",tiempo);
  }
  return 0;
}
