//Proceso que escribe en PIPE FIFO
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>


int main()
{
  int fp;
   time_t t;
 int numero1;
srand((unsigned) time(&t));
//Generamos numero aleatorio entre 1 y 50
numero1=rand() % 10;
  fp = open("FIFO1", 1);
  printf("Mandando información al pipe FIFO...%d\n",numero1);
  write(fp,&numero1, sizeof(numero1));
  close(fp);
    int p, bytesleidos,buffer;   
  p=mkfifo("FIFO1", S_IFIFO|0666);//permiso de lectura y escritura
   fp = open("FIFO1", 0);
   bytesleidos= read(fp, &buffer, sizeof(buffer)); 
  close(fp);
   printf("Leyendo informacion del pipe FIFO2...");
   printf(" %d\n",buffer); 
     unlink("FIFO01");  

}
