#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <time.h>
void main(){
     int fd[2]; 
     pid_t pid;   
     // Creamos el pipe
     pipe(fd);      
     //Se crea un proceso hijo
     pid = fork();
     if (pid==0)
     {

                time_t t;
		 int numero1;
		 srand((unsigned) time(&t));
		 close(fd[0]);
		 for(int i = 0; i<2;i++){
		 numero1=rand() % 50; 
		 printf("\t enviando %d \n", numero1);
		 write(fd[1], &numero1, sizeof(numero1));  
		 }
     }
     else
     {
 
                wait(NULL);    
		int j;
                close(fd[1]); // Cierra el descriptor de escritura
                printf("El padre se dispone a leee del PIPE \n");
                int a[2];
                int contador = 0;
                while(1){
                contador = contador + 1;
                read(fd[0], &j, sizeof(j));
                if(contador == 3){
                printf("\t la suma de %d y %d es %d \n", a[0],a[1],a[0]+a[1]);
                printf("\t la resta de %d y %d es %d \n", a[0],a[1],a[0]-a[1]);
                printf("\t la multiplicacion de %d y %d es %d \n", a[0],a[1],a[0]*a[1]);
                printf("\t la division de %d y %d es %d \n", a[0],a[1],a[0]/a[1]);
                break;
                }
                 a[contador - 1] = j ;
                 printf("\t Mensaje leido del pipe: %d \n", j);
                }
     } 
}


//Generamos numero aleatorio entre 1 y 50


