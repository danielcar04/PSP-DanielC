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
  time_t hora;
  char *fecha ;
  time(&hora);
  fecha = ctime(&hora) ;
printf("alarma recibida a las %s", fecha);
}
int main()
{
  int veces, segun,cont;
  cont=0;
  printf("cuantas veces sonara la alarma\n");
  scanf("%d",&veces);
  printf("cada cuantos segundos se activará\n");
  scanf("%d",&segun);
  signal(SIGINT, sig_handler);
  signal(SIGALRM,alarma);
  while(1){
  if(cont == veces){
  break;
  }
  alarm(segun);
  pause();
  cont = cont + 1;
  }
 return 0;
}
