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
time_t hora;
 	char *fecha ;
	time(&hora);
	fecha = ctime(&hora) ;
if (tiempo == SIGALRM)
printf("alarma recibida a las %s \n",fecha);
}

int main(void)
{
printf("cuantas alarmas quieres\n");
int veces;
scanf("%d",&veces);
printf("cada cuanto las quieres\n");
int repetir;
scanf("%d",&repetir);
int contador = 1;
signal(SIGINT, sig_handler); //para pararlo sin usar el kill  
signal(SIGALRM,sig_tiempo);
  while(1) {
      if (contador > veces){
    break;
    }else{
    alarm(repetir);
    pause();
    contador = contador + 1;
    }
  }
  return 0;
}
