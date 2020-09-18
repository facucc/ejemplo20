#Respuestas laboratorio 3






1. Debug con gdb


[imagen]
Error de sintaxis en una variable mal escrita.


2. Debug con core dumps

            #include <stdio.h>
void main() {	
    char temp[] = "Paras";
    char* punt=temp;
    int i;
    i=0;   
    
    punt[3]='F';

    for (i =0 ; i < 5 ; i++ )
        printf("%c\n", temp[i]);
} 



Preguntas

¿Cómo puedo obtener el coredump de un proceso que esta corriendo?

Se puede obtener en la direccion  /var/lib/systemd/coredump/
En la seccion del man core "Core dumps and systemd"


¿Cómo se llama por defecto los archivos de core dump?

Los archivos coredump se llaman por defecto "core" o "core.pid"
donde pid es el ID del proceso que produjo el coredump

El archivo / proc / sys / kernel / core_pattern puede    configurarse para definir un conjunto de especificacion para utilizarse para nombrar los core dump.

Consultando el man en la seccion "Naming of core dump files" estan las especificaciones para configurar los nombres de los coredump.

       

¿Qué restricciones de tamaño tienen por defecto y con qué comando y función puedo modificarlas?





