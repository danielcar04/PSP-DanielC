#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <time.h>
void main(){
     int fd[2]; 
     int df[2];
     pid_t pid;   
     // Creamos el pipe
     pipe(fd);  
     pipe(df);    
     //Se crea un proceso hijo
     pid = fork();
     if (pid==0)
     {
     		int j;
                close(fd[1]); // Cierra el descriptor de escritura
                printf("El hijo se dispone a leee del PIPE \n");
                int a = 0;
                read(fd[0], &j, sizeof(j));
                a = j;
                for(int i = 1; i<j;i++){
                printf("\t multiplicando %d por %d \n",a, i);
                a = a * i;          
                }
                printf("\t enviando %d \n", a);
                close(df[0]);
		 write(df[1], &a, sizeof(a)); 
                 
     }          
     else
     {
		 time_t t;
		 int numero1;
		 srand((unsigned) time(&t));
		 close(fd[0]);
		 numero1=rand() % 10; 
		 printf("\t enviando %d \n", numero1);
		 write(fd[1], &numero1, sizeof(numero1));  
                wait(NULL);  
                int j;
                close(df[1]); // Cierra el descriptor de escritura
                printf("El hijo se dispone a leee del PIPE \n");
                read(df[0], &j, sizeof(j));
                int a = j;
                printf("\t el factorial de %d es %d \n",numero1, a);
     } 
}


//Generamos numero aleatorio entre 1 y 50


