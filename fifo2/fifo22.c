//Proceso que lee del PIPE FIFO
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 



int main(void)
{
  int fp;  
  int p, bytesleidos, buffer;
  p=mkfifo("PIPE02", S_IFIFO|0666);//permiso de lectura y escritura
   fp = open("PIPE02", 0);  
   bytesleidos= read(fp, &buffer, sizeof(buffer)); 
   close(fp);
   int a = buffer;
   printf("Leyendo informacion del PIPE02...\n");    
   for (int i = 1;i<=buffer;i++){
        printf("\t multiplicando: %d por %d\n", a,i);
	a=a*i; 
   }

 fp = open("PIPE02", 1);  
  printf("Mandando información al PIPE02... %d\n",a);
  write(fp,&a,sizeof(a));
   close(fp);
  unlink("PIPE02");
}
