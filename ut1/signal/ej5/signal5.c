#include<stdio.h>
#include<signal.h>
#include<unistd.h>
#include <time.h>
#include <stdlib.h>
int fd[2];
pid_t pid2,pid3;

//Función de manejo de la señal
void sig_handler(int signo)
{	if (signo == SIGINT){
	exit(0);	
	}
}
void salir(int signo){
exit(0);
}
void handlepar(int signo){
	int j;
	read(fd[0], &j, sizeof(j));
	int x = j;
	printf("\t numero par recibido: %d por el hijo con pid %d\n", x,getpid());
		
}
void handleimpar(int signo){
	int j;
	read(fd[0], &j, sizeof(j));
	int x = j;
	printf("\t numero impar recibido: %d por el hijo con pid %d\n", x,getpid());

}
		
int main(void)
{
pipe(fd);
    if ((pid2 = fork()) == 0) {
        // Proceso P2
        
        signal(SIGUSR1, handlepar);
        while(1){
        sleep(1);
        }
    } else if ((pid3 = fork()) == 0) {
        // Proceso P3
     
        signal(SIGUSR2, handleimpar);
         while(1){
        sleep(1);
        }
        }else{
	  signal(SIGINT, sig_handler); //para pararlo sin usar el kill  
	  signal(SIGUSR1, salir);
	  int numero;
	  while(1) {
	 	printf("dime un numero\n");
		scanf("%d",&numero);
		write(fd[1],&numero,sizeof(numero));
		if (numero ==0){
			break;
		}
		if(numero %2 ==0){
		printf("enviando a par\n");
			kill(pid2,SIGUSR1);
		}else if(numero %2 ==1){
		printf("eniviando a impar\n");
			kill(pid3,SIGUSR2);
		}
		sleep(0.1);
	  }
	  close(fd[1]);
	  return 0;
	  }
  }

