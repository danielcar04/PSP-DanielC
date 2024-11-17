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
     		char j;
     		int a;
     		printf("\t dime el dni\n");
     		scanf("%d",&a);
                close(df[0]);
		 write(df[1], &a, sizeof(a)); 
                close(fd[1]); // Cierra el descriptor de escritura
                printf("El hijo se dispone a leee del PIPE \n");
                read(fd[0], &j, 1);
                char x = j;
                printf("la letra es %c \n",x);
                
                 
     }          
     else
     {
     		
     		 char letra[] = "TRWAGMYFPDXBNJZSQVHLCKE";
     		 int j;
                close(df[1]); // Cierra el descriptor de escritura
                printf("El hijo se dispone a leee del PIPE \n");
                read(df[0], &j, sizeof(j));
                int a = j;
                a = a%23;
		 close(fd[0]);
		 write(fd[1], &letra[a], 1);  
                wait(NULL);
                
     } 
}


//Generamos numero aleatorio entre 1 y 50


