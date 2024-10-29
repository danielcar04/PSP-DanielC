#include<stdio.h>
#include<signal.h>
#include<unistd.h>
#include <time.h>
#include <stdlib.h>

//Función de manejo de la señal
void sig_handler(int signo)
{
time_t hora;
 	char *fecha ;
	time(&hora);
	fecha = ctime(&hora) ;
  	if (signo == SIGINT)
	printf("finalizacion del proceso %d: a las %s",getpid(),fecha);
	exit(0);
	
}


int main(void)
{
 	time_t hora;
 	char *fecha ;
	time(&hora);
	fecha = ctime(&hora) ;
	printf("inicio del proceso %d: a las %s",getpid(),fecha);
  signal(SIGINT, sig_handler);
 //Bucle infinito proceso queda a la espera de la señal
  while(1) 
    sleep(1);
  return 0;
}
