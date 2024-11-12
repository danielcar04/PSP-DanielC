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
  p=mkfifo("FIFO1", S_IFIFO|0666);//permiso de lectura y escritura
   fp = open("FIFO1", 0);  
   bytesleidos= read(fp, &buffer, 1); 
   int a = buffer;
   printf("Leyendo informacion del pipe FIFO2...\n");    
   for (int i = 1;i<=buffer;i++){
        printf("\t multiplicando: %d por %d\n", a,i);
	a=a*i; 
}
  fp = open("FIFO2", 1);
  printf("Mandando información al pipe FIFO... %d\n",a);
  write(fp,&a,sizeof(a));
  close(fp);    
  
  return(0);
}
