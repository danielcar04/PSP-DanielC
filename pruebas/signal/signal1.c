#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <time.h>
/* Función para gestión de señales*/
void manejador( int numsenal )
{
  time_t hora;
  char *fecha ;
  time(&hora);
  fecha = ctime(&hora) ;
 printf("proceso terminado a las %s", fecha);
 exit(0);
}

int main()
{
  signal(SIGINT,manejador);
  time_t hora;
  char *fecha ;
  time(&hora);
  fecha = ctime(&hora) ;
   printf("proceso empezando a las %s", fecha);
  while(1){
  sleep(1);
  }
 exit(0);
}
