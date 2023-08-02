**Practica 1**

**Estudiante:** Jorge Ignacio Heredia Bazoalto

_ **Parte 1:** _

_ **Piensa en una situación donde hayas utilizado una estructura de datos convencional como un array, una lista enlazada o una pila. Detalla sobre los beneficios y las limitaciones de esa estructura en ese contexto específico. ¿Por qué elegiste esa estructura de datos?** _

Elegí usar una pila o (stack) para el algoritmo de DFS (Deep First Search) en un grafo. Ya que, para conseguir un mejor resultado de la búsqueda, es necesario analizar primero el ultimo nodo que ingreso a la pila.

El usar un objeto como una pila, nos ayuda a reducir el número de líneas de código para acceder al ultimo elemento ingresado, ya que siempre estará en la cabeza. Una vez se analizó la cabecera se puede eliminar fácilmente para continuar con el siguiente.

Existen unas cuantas limitaciones de la pila, ya que si buscamos hacer un acceso aleatorio a los elementos es mucho más complicado, además se requiere un espacio extra de memoria por cada elemento para almacenar el puntero al siguiente elemento.

_ **Compara y contrasta las características, ventajas y desventajas en términos de tiempo de ejecución, capacidad de almacenamiento y facilidad de implementación de un arraylist y un linkedlist** _

Tiempo de ejecución

ArrayList: El acceso aleatorio o indexado es más eficiente.

LinkedList: Tiene una gran desventaja si es que estamos tratando de acceder un elemento sin saber su posición, ya que recorrerá gran parte de la lista desde el principio para buscarlo. Por otro lado es mucho mas eficiente insertar elementos en medio de la lista, al igual que eliminarlos.

Capacidad de almacenamiento

ArrayList: Si bien un ArrayList reserva espacios cada cierto número de elementos, para asegurarse de que puede extenderse, alguno de esos espacios reservados puede permanecer vacío y sin uso durante mucho tiempo. Aun así tiene ventaja sobre una LinkedList si se habla de muchos elementos a almacenar.

LinkedList: La gran desventaja de una LinkedList radica en que se necesita mínimo un espacio de memoria extra por cada elemento, para guardar la referencia al nodo siguiente, si se quiere una LinkedList bidireccional, se requerirían 2 espacios en memoria extra por cada elemento. Lo que si hablamos de gran cantidad de datos es demasiado.

_ **Elige dos estructuras de datos convencionales que hayas implementado en el pasado. Compara y contrasta sus características, ventajas y desventajas en términos de tiempo de ejecución, capacidad de almacenamiento y facilidad de implementación. Reflexiona sobre en qué situaciones específicas preferirías utilizar una sobre la otra y por qué.** _

_ **HashMap vs ArrayList** _

HashMap tiene la ventaja de mantener una relación de la llave con su valor almacenado, lo que nos permite acceder de forma aleatoria a elementos bastante rápido, sin embargo, el tratar de iterar uno por uno cada elemento de un Hashmap puede ser demasiado costoso en términos de tiempo de ejecución.

No obstante, un ArrayList es mucho más sencillo y rápido de implementar, aunque sus búsquedas aleatorias puedan ser un tanto más lentas y la inserción y/o eliminación requieran mas recursos.

HashMap siempre ocupara más espacio de almacenamiento que un ArrayList, ya que el primero necesita guardar la llave del valor y el segundo solo requiere conocer el valor.

_ **Parte 2:** _

_ **¿Qué implicaciones tiene la elección de una estructura de datos en el diseño y la eficiencia de un programa?** _

Puede mejorar la fluidez y rapidez de respuesta de un programa, además de que la elección de una estructura de datos adecuada al problema abordado facilitara la codificación de sus soluciones, ahorrando tiempo y muchas veces líneas de código repetitivas.

_ **¿Cuál es la diferencia entre una estructura de datos convencional y una estructura de datos avanzada?** _

La principal diferencia radica en la complejidad y el alcance de sus capacidades, ya que las convencionales se enfocan en ser eficientes para problemas básicos, en cambio las estructuras avanzadas buscan solucionar problemas más complejos de una manera eficiente. Esto implica que las estructuras avanzadas normalmente tendrán más opciones y más métodos.

_ **¿Cuáles son algunas ventajas de utilizar estructuras de datos avanzadas en comparación con las convencionales?** _

Si tenemos una estructura de datos avanzada podemos usar los métodos y herramientas de esta de una manera mucho mas entendible dentro del código. Lo que seria mucho mas complicado si usamos estructuras convencionales.

_ **¿Cuáles son las aplicaciones comunes de los árboles B en problemas reales?** _

Su principal aplicación esta en los arboles de búsqueda, lo que nos permite buscar información dentro de muchos datos de una manera rápida. Además de que el almacenamiento equilibrado permite usarse para múltiples acciones enfocadas en el almacenamiento y administración de datos, como ser; bases de datos, sistemas de archivos, almacenamiento cache y bases de datos geoespaciales.

_ **¿Cuáles son las aplicaciones comunes de los heaps en problemas reales?** _

Las aplicaciones principales para los heaps son las colas de prioridad, algoritmos de búsqueda y ordenación, algoritmos de comprensión y codificación, asignación dinámica de memoria en los sistemas operativos y por ultimo algoritmos de exploración de grafos.

_**¿Cómo se comparan las estructuras de datos convencionales (como arrays y listas enlazadas) con los árboles B en términos de tiempo de ejecución, capacidad de almacenamiento y facilidad de implementación?**_

En tiempo de ejecución algunas estructuras convencionales como los arrays tienen un tiempo de ejecución O(1) lo que es lineal y estable, pero otros como las listas enlazadas pueden tener un O(n) al acceder a elementos aleatoriamente. En cambio un árbol B tiene O(log n) en equilibrio.

En términos de capacidad de almacenamiento, las listas enlazadas requieren de espacios extra por cada elemento, sim embargo un árbol b esta optimizado para almacenar grandes cantidades de datos.

En términos de implementación las estructuras convencionales son mucho más fáciles de implementar, ya que no hay que tener tantas reglas o consideraciones.

_ **¿Cuáles son algunas consideraciones importantes al seleccionar una estructura de datos para manejar grandes volúmenes de datos?** _

Como se planea acceder o usar estos datos. Por ejemplo, si los datos a manejar son para representar una cola en el banco, es incoherente usar un stack.

Además, hay que considerar si la estructura de datos puede manejar ese volumen o si se destaca mas en el manejo de pequeñas cantidades.

_ **¿Qué implicaciones tiene la elección de una estructura de datos en la flexibilidad y escalabilidad de un programa?** _

Una mala estructura de datos puede implicar que un programa no sea escalable o que para serlo requiera de mayor inversión en hardware. Lo que también resultaría en problemas para los desarrolladores a la hora de resolver nuevos problemas.

_ **¿Cuál es la relación entre la complejidad del código y la elección de una estructura de datos adecuada?** _

Una estructura de datos adecuada hace que el código sea legible y entendible para el resto. Si bien la complejidad se puede ver reflejada a la hora de construir la estructura de datos, a la hora de solucionar el problema usando esa estructura, nos facilita el trabajo.