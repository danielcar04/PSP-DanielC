#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <time.h>
int tiempo = 5;
FILE *f;
/* Función para gestión de señales*/
void sig_handler(int signo)
{	
	time_t hora;
 	char *fecha ;
	time(&hora);
	fecha = ctime(&hora) ;
	fprintf(f, "se intentó salir a las %s",fecha);
	fflush(f);
}
void alarma( int a)
{
if(a == SIGALRM){
printf("han pasado %d segundos\n", tiempo);
}
}
int main()
{
  f = fopen("salidas.txt","ab");
  signal(SIGINT, sig_handler);
  while(1){
  sleep(1);
  }
   fclose(f);
 exit(0);
}
