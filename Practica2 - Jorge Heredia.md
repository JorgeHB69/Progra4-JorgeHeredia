**[Practica 2]{.underline}**

***[Estudiante:]{.underline}*** Jorge Ignacio Heredia Bazoalto

***¿Cuál es la diferencia entre un árbol binario, un árbol de búsqueda
binaria y un árbol AVL?***

Un árbol binario, simplemente es un árbol cuyos nodos solo pueden tener
2 hijos para cumplir con la regla binaria.

En cambio, un árbol de búsqueda binaria esta basado en un árbol binario,
pero cuyos nodos están ordenados, normalmente del lado derecho están los
nodos mayores al nodo padre y a la izquierda los menores.

Un árbol AVL es un árbol optimizado para la búsqueda, lo que intenta es
que la altura de la rama izquierda no difiera por mas de un nodo con la
rama derecha. Por lo que los métodos de inserción y eliminación usan
algoritmos para mantener el equilibrio en las ramas.

***¿Cuáles son las ventajas y desventajas de usar un árbol en lugar de
una lista enlazada o un arreglo?***

Un árbol comúnmente nos permite realizar operaciones de búsqueda de
manera eficiente, además de que las operaciones de inserción y
eliminación son más eficientes (O(log n)) comparado con los arrays o
listas enlazadas (O(n)).

Otra gran ventaja de los arboles es la representación que dan de las
estructuras jerárquicas, pueden ayudar a problemas que requieran una
organización.

Dentro de las desventajas de un árbol esta el espacio adicional que se
usa para guardar los punteros a los nodos hijos y la implementación
mucho mas compleja que requiere.

***¿Cómo realizar el recorrido en profundidad (DFS) y recorrido en
anchura (BFS) en un árbol binario?***

El algoritmo DFS y BFS tienen una sola diferencia y es que DFS utiliza
una pila (Stack) para analizar siempre el ultimo nodo ingresado, que
normalmente son los que están mas abajo o más en profundidad. En cambio,
BFS usa una cola, para analizar siempre los nodos del primer nodo
ingresado, que normalmente son los que estaban en la anchura del árbol.

Además, notar que estos algoritmos pueden ser iterativos o recursivos.

Algoritmo DFS:

1.  Tener un nodo de inicio o root.

2.  Instanciar un stack y pasarle root.

3.  Dentro de un ciclo while, iterar el stack siempre que haya algo
    adentro.

4.  Obtenemos el primer elemento del stack y comparamos el valor con el
    valor buscado.

5.  Si no se encuentra, obtener sus hijos y agregarlos al stack.

Algoritmo BFS:

1.  Tener un nodo de inicio o root.

2.  Instanciar un Queue y pasarle root.

3.  Dentro de un ciclo while, iterar el Queue siempre que haya algo
    adentro.

4.  Obtenemos el primer elemento del Queue y comparamos el valor con el
    valor buscado.

5.  Si no se encuentra, obtener sus hijos y agregarlos al Queue.

***¿Cómo equilibrar un árbol binario para asegurar un tiempo de búsqueda
eficiente?***

Lo principal es que todos los nodos en el mismo nivel tengan sus 2
hijos. Pero existen otro tipo de equilibrado para asegurar que la
búsqueda sea mucho más eficiente, como ser; el árbol AVL y árbol rojo y
negro.

***¿Cuál es el algoritmo para encontrar el ancestro común más bajo (LCA)
en un árbol?***

Teóricamente se puede usar DFS o BFS para apoyar este algoritmo, se
consiguen mejores resultados con DFS. Pero se necesita tener un puntero
hacia el padre de los nodos. Y los dos nodos comparados deben de estar
en el mismo nivel, ir iterando los padres de los 2 punteros o nodos, y
comparando a ver si se encuentran en algún momento.

***¿Cómo implementar un árbol de sufijos para realizar búsquedas
eficientes en cadenas de texto?***

***¿Cómo se puede utilizar un árbol de decisión para clasificar datos en
problemas de aprendizaje automático?***

En términos sencillos un árbol de decisión es aquel que cada nodo
representa una pregunta o condición sobre algún rasgo o atributo que se
busque clasificar. Además, cada hijo de los nodos son posibles
respuestas que pueden contener mas preguntas para clasificar mejor el
objeto. Las hojas del final representan la salida final o la categoría
del objeto.

***¿Cómo utilizar un árbol para representar y organizar una jerarquía de
datos, como en la organización de archivos en un sistema de archivos?***

Un árbol de jerarquía es sencillo de implementar, ya que es un árbol
n-ario donde en base a un nodo raíz se agregan otros nodos hijos,
dependiendo la profundidad o nivel en el cual se agreguen nuevos
archivos. Es importante recalcar que cada nodo del árbol representa una
carpeta o archivo.

***¿Cuál es la diferencia entre un árbol n-ario y un árbol binario? ¿En
qué casos es preferible usar uno sobre el otro?***

Un árbol binario tiene como regla principal que cada nodo solo puede
tener un máximo de 2 nodos hijos, en cambio un árbol n-ario puede tener
*n* nodos hijos. Lo que hace a un árbol binario más eficiente en
búsquedas y mucho mas sencillo de ordenar, en cambio el árbol n-ario
será más difícil de ordenar al tener una cantidad variable de nodos
hijos, además la búsqueda en anchura y profundidad pueden tardar más.

***¿Cuál es la complejidad temporal de insertar y eliminar un elemento
en un árbol de búsqueda binaria promedio y en el peor caso?***

La complejidad temporal radica en que el mejor caso o el caso promedio
tendrán un árbol de búsqueda balanceado lo que nos garantizara que
tenemos tiempos de búsqueda O(log n), pero en el peor caso, en un árbol
que no esta balanceado, tenemos varias secuencias parecidas a listas
enlazadas, lo que vuelve el tiempo de búsqueda o recorrido, igual a
O(n).

***¿Cuál es la diferencia entre un árbol de búsqueda binaria y un árbol
de búsqueda binaria equilibrada? ¿Por qué es importante el balanceo en
los árboles?***

La diferencia radica en que el árbol de búsqueda binaria, simplemente
esta ordenado con lo mayor a la derecha y lo menor a la izquierda, pero
en caso de tener más elementos mayores que menores, el árbol se
desequilibra. Lo que se soluciona con un árbol de búsqueda binaria
equilibrada, ya que tiene algoritmos que lo equilibran y balancean y
siempre tener una misma altura.

***¿Cómo se puede realizar una recorrida en profundidad (DFS) en un
árbol n-ario utilizando recursión?***

El árbol n-ario deberá tener una lista de sus nodos hijos. Verificamos
si el nodo raíz es o no el nodo buscado, en caso de que no, se recorre
la lista de hijos llamando a la función recursivamente, pasando como
parámetro los hijos.

***¿Qué es un grafo y cuáles son sus componentes básicos?***

Un grafo es una estructura de datos que representan varios nodos que
pueden interconectarse de diferente manera, sin seguir un orden
jerárquico. Sus componentes básicos son los **nodos**, que están unidos
por **aristas**, cuyas aristas pueden ser unidireccionales o
bidireccionales, además pueden tener un **peso** para representar
distancia o otras representaciones.

Tiene usos comunes en la vida cotidiana como representar mapas, redes
sociales o redes de computadoras.

***¿Cuál es la diferencia entre un grafo dirigido y un grafo no
dirigido?***

El grafo dirigido detalla que un **nodo A** esta relacionado con el
**nodo B**, pero el **nodo B** no esta relacionado con el **nodo A**. En
cambio, un nodo no dirigido se considera bidireccional, ósea que ambos
están relacionados entre sí, por lo que pueden accederse y comunicarse.

***¿Cuál es la importancia de los algoritmos de búsqueda en grafos, como
BFS (Breadth-First Search) y DFS (Depth-First Search)?***

Estos algoritmos nos ayudan a encontrar los caminos o rutas mas
eficientes para ciertos problemas, además de que se usan para solucionar
problemas en inteligencia artificial, pero uno de los usos más típicos
es el mapeo.

***¿Qué es un grafo ponderado y qué aplicaciones tiene en la vida
real?***

Un grafo ponderado es aquel que tiene peso en sus relaciones (Aristas),
lo que hace que se pueda distinguir la importancia entre una arista y
otra. Por ejemplo, en un grafo usado para representar un mapa, las
aristas entre nodos tendrán un peso, las aristas con menor peso
representarán las calles o puntos más cercanos.

***¿Cómo se puede determinar si un grafo es conexo y qué es una
componente conexa?***

Para determinar si un grafo es conexo, se pueden usar los algoritmos BFS
o DFS y marcar los nodos visitados, si es que alguno no fue visitado no
es conexo.

***¿Cuál es el algoritmo de Dijkstra y cómo se utiliza para encontrar el
camino más corto en un grafo ponderado?***

***¿Qué es el algoritmo de Kruskal y cuál es su utilidad en el contexto
de los árboles de expansión mínima?***

***¿Qué es la teoría de redes y cuál es su relación con los grafos en
aplicaciones del mundo real?***

La teoría de redes es una rama de la matemática y ciencia de
computadoras que busca representar las diferentes tipos de redes del
mundo como las redes sociales o de computadoras mediante grafos.
