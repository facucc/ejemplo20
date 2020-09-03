#Laboratorio2:Respuestas

###1.c-strings

 >Actividad resuelta en ejercicio1.c

###2. Arreglos

  >Actividad resuelta en ejercicio2.c

##Respuestas Estructuras

Conteste las siguientes preguntas:

      1. ¿Cómo utilizar typedef junto a struct? ¿Para qué sirve? Ejemplo.
      2. ¿Qué es packing and padding ?

####Respuestas

1.La palabrareservada **typedef** proporciona un mecanismo para la creacion de sinonimos (o alias) para las estructuras.
Es decir me permite a la hora de inicializar una estructura poner el alias directamente y asi evitar poner todo el tipo de struct.

Ejemplo:

typedef struct Nombre_struct{

... atributos

}sinonimo;

2.

* padding:Como el procesador lee 1 palabra(4 byte sistema de 32 bits o 8 byte sistema de 64bits)  cada ciclo de reloj, me permite que cada dato este guardado en memoria consecutiva ;asi evita que el procesador busque un dato dividido en memoria en varios ciclos de reloj.

    Tambien el sistema alinea en memoria de acuerdo al dato de mayor tamaño de la estructura.

* packing:Este mecanismo me permite que no se desperdicie memoria, renunciando a ir a buscar datos en la memoria en 1 ciclo de reloj.

####Esctructura_Base_Data

        typedef struct {
            char a;     /1byte/
            char b;     /1byte/
            int  x;     /4byte/
            unsigned short int y;       /2byte/
            char c;     /1byte/
            unsigned short int z;       /2byte/
            char d[3];      /3byte/
        } BaseData;

Usando padding:

![struct1](/home/facundo/Escritorio/Imagenes/imagen.png)

4Byte*5=20Bytes

####Esctructura_Reorder_Data

        typedef struct {
            char a;     /1byte/
            char b;     /1byte/
            int  x;     /4byte/
            unsigned short int y;       /2byte/
            unsigned short int z;       /2byte/
            char c;     /1byte/
            char d[3];      /3byte/
        } ReorderData;

Usando padding:

![struct2](/home/facundo/Escritorio/Imagenes/struct2.png)

4Byte*4=16Bytes

####Esctructura_Extended_Data

        typedef struct {
            long unsigned int ll; /8byte/
            char a;     /1byte/
            char b;     /1byte/
            unsigned short int y;       /2byte/
            int  x;     /4byte/
            unsigned short int z;       /2byte/
            unsigned short int w;       /2byte/
            char c;     /1byte/
            char d[3];      /3byte/
        } ExtendedData;
        
Usando padding:

![struct3](/home/facundo/Escritorio/Imagenes/struct3.png)

4Byte*6=24Bytes

####Esctructura_Base_Data_Packed

            typedef struct  __attribute__((packed)) {
                char a;     /1byte/
                char b;     /1byte/
                int  x;     /4byte/
                unsigned short int y;       /2byte/
                char c;     /1byte/
                unsigned short int z;       /2byte/
                char d[3];      /3byte/
         } BaseDataPacked;
         
Usando packing

![struct3](/home/facundo/Escritorio/Imagenes/struct4.png)

14 Bytes

###3a:El archivo binario generado se llama ejer3.o
###3b.Apartir de los archivos struct.h y lab.c responda las preguntas


* Explique por que la expresion que calcula  limit y limit_aux generan el mismo resutado 

>limit=> Primero le asigno la direccion inicial de la estructura y le sumo 20 bytes que es donde se termina la estructura y comienza la     siguiente estructura.

>limit_aux=> En esta expresion, le asigno la direccion que ocupa la estructura y le sumo 1 ,que es equivalente apuntar a la direccion siguiente de memoria(siguiente estructura).

* Explique los valores que se muestran en pantalla en cada iteracion del for

> Cada for me imprime cual byte de la estructura es y el valor del dato en ese byte.








