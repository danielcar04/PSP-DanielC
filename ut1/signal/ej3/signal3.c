#include<stdio.h>
#include<signal.h>
#include<unistd.h>
#include <time.h>
#include <stdlib.h>
	FILE *f;
//Función de manejo de la señal
void sig_handler(int signo)
{
time_t hora;
 	char *fecha ;
	time(&hora);
	fecha = ctime(&hora) ;
	fprintf(f, "se intentó salir a las %s",fecha);
	fflush(f);
}


int main(void)
{
	f = fopen("salidas.txt","a");
 	time_t hora;
 	char *fecha ;
	time(&hora);
	fecha = ctime(&hora) ;
	printf("inicio del proceso %d: a las %s",getpid(),fecha);
  signal(SIGINT, sig_handler);
 //Bucle infinito proceso queda a la espera de la señal
  while(1){ 
    pause();
    }
    fclose(f);
  return 0;
}
