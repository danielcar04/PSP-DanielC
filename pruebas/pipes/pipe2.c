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
     		int j;
                close(fd[1]); // Cierra el descriptor de escritura
                printf("El hijo se dispone a leee del PIPE \n");
                int a = 0;
                while(1){
                read(fd[0], &j, sizeof(j));
                if(j == '+'){
                printf("\t la suma es %d \n", a);
                break;
                }
                 a = a + j ;
                 printf("\t Mensaje leido del pipe: %d \n", j);
                }
                
     
     }
     else
     {
		 time_t t;
		 int numero1;
		 srand((unsigned) time(&t));
		 close(fd[0]);
		 for(int i = 0; i<5;i++){
		 numero1=rand() % 50; 
		 printf("\t enviando %d \n", numero1);
		 write(fd[1], &numero1, sizeof(numero1));  
		 }
		 write(fd[1], "+", 1);  
                wait(NULL);    
     } 
}


//Generamos numero aleatorio entre 1 y 50


