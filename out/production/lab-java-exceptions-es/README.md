
![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB | Java Excepciones

## Introducción

Acabamos de aprender cómo throw (lanzar), manejar y probar excepciones, así que practiquemos un poco más.

<br>

## Requisitos

1. Haz un fork de este repositorio.
2. Clona este repositorio.
3. Añade a tu instructor y a los calificadores de la clase como colaboradores de tu repositorio. Si no estás seguro de quiénes son los calificadores de tu clase, pregunta a tu instructor o consulta la presentación del primer día.
4. En el repositorio, crea un proyecto de Java y añade el código para las siguientes tareas.

## Entrega

Una vez que termines la tarea, envía un enlace URL a tu repositorio o tu solicitud de extracción en el campo de abajo.

<br>

## Instrucciones

1. Crea una clase `Person` que tenga las siguientes propiedades:
   - `id`: un número entero
   - `name`: una cadena formateada como "nombreApellido"
   - `age`: un número entero
   - `occupation`: una cadena

   La clase `Person` debería tener los siguientes métodos:
   - Un constructor que tome un número entero `id`, una cadena `name`, un número entero `age` y una cadena `occupation` como argumentos y establezca sus propiedades respectivas.
   - Un método `setAge` que tome un número entero `age` y establezca la propiedad `age`, pero lance un error si `age` es menor que 0.
   - Un método `equals` que tome un objeto `Person` y devuelva `true` si sus propiedades son iguales, excluyendo la propiedad `id`.
   
2. Crea una clase `PersonsList` que contenga una lista de objetos `Person`.
   - Crea un método `findByName` que tome una cadena `name` y devuelva el objeto `Person` con un `name` que coincida exactamente. El parámetro `name` debería estar formateado como "firstName lastName". Este método debería lanzar una excepción si el parámetro `name` no está formateado adecuadamente.
   - Crea un método `clone` que tome un objeto `Person` y devuelva un nuevo objeto `Person` con las mismas propiedades, excepto con un nuevo `id`.
   - Crea un método que tome un objeto `Person` como parámetro y use el método `toString` para escribir la información de `Person` en un archivo. Este método debería manejar cualquier error necesario.

  <br>

## Casos de test

1. Prueba el método `setAge` para asegurarte de que lanza un error si la edad es menor que 0.
2. Prueba el método `findByName` para asegurarte de que encuentra y devuelve correctamente el objeto `Person` correcto cuando se le da un nombre correctamente formateado.
3. Prueba el método `findByName` para asegurarte de que lanza una excepción si el parámetro `name` no está formateado correctamente.
4. Prueba el método `clone` para asegurarte de que crea un nuevo objeto `Person` con las mismas propiedades que el original, excepto con un nuevo `id`.

<br>

## FAQs (Preguntas frecuentes)

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">Estoy atascado y no sé cómo resolver el problema o por dónde empezar. ¿Qué debo hacer?</summary>

  <!-- ✅ -->

  Si estás atascado en tu código y no sabes cómo resolver el problema o por dónde empezar, debes dar un paso atrás y tratar de formular una pregunta clara y directa sobre el problema específico que enfrentas. El proceso que seguirás al tratar de definir esta pregunta te ayudará a limitar el problema y a encontrar soluciones potenciales.

  Por ejemplo, ¿estás enfrentando un problema porque no entiendes el concepto o estás recibiendo un mensaje de error que no sabes cómo arreglar? Por lo general, es útil intentar formular el problema de la manera más clara posible, incluyendo cualquier mensaje de error que estés recibiendo. Esto puede ayudarte a comunicar el problema a otras personas y, potencialmente, a obtener ayuda de tus compañeros o recursos en línea.

  Una vez que tengas una comprensión clara del problema, deberías poder comenzar a trabajar hacia la solución.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cómo creo un proyecto Maven en IntelliJ?</summary>

  <!-- ✅ -->

  Para crear un proyecto Maven en IntelliJ, puedes seguir estos pasos:

   1. Abre IntelliJ IDEA y haz clic en el botón "Create New Project".
   2. En el diálogo "New Project", selecciona "Maven" como el sistema de compilación.
   3. Especifica el nombre del proyecto.
   4. En la sección "Project Location", especifica una ubicación donde quieres guardar tu proyecto.
   5. Selecciona la casilla de verificación "Create Git repository" para inicializar el repositorio git al crear el proyecto.
   6. Haz clic en el botón "Create" para crear el proyecto Maven.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cuál es el propósito del método "toString()" y cómo puedo anularlo en Java?</summary>

  <!-- ✅ -->

  El método `toString()` en Java es un método que se llama automáticamente cuando se pasa un objeto como una cadena. El propósito de este método es devolver una representación en cadena de un objeto. Por defecto, el método `toString()` devuelve el nombre de la clase del objeto y su dirección de memoria.

  Es una buena práctica anular el método `toString()` en tus propias clases para proporcionar una representación en cadena significativa de tus objetos. Esto puede ser útil para fines de depuración y registro.

  Aquí hay un ejemplo de cómo anular el método `toString()` en Java:

  ```java
  class Circle {
      int x, y;
      int radius;

      public String toString() {
          return "Circle [x=" + x + ", y=" + y + ", radius=" + radius + "]";
      }
  }
  ```

  En este ejemplo, la clase `Circle` anula el método `toString()` para devolver una representación en cadena del objeto `Circle`. Cuando se pasa un objeto de la clase `Circle` como una cadena, esta implementación personalizada de `toString()` se llamará y devolverá la representación en cadena deseada.

  Es importante tener en cuenta que el método `toString()` debe devolver una representación en cadena concisa y legible por humanos del objeto, ya que se utiliza comúnmente para fines de depuración y registro.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cuál es el propósito de usar la palabra clave "throws" en Java y cuándo debo usarla?</summary>

  <!-- ✅ -->

  La palabra clave `throws` en Java se utiliza para declarar que un método puede lanzar una excepción. El propósito de usar la palabra clave `throws` es indicar que una excepción puede ser lanzada y requiere que el método llamante maneje la excepción. Si un método declara que lanza una excepción, el método llamante debe manejar la excepción usando un bloque try-catch o declarar que también lanza la misma excepción.

  Aquí hay un ejemplo de cómo puedes usar la palabra clave `throws` en un método:

  ```java
  public void readFile(String fileName) throws FileNotFoundException {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      // code to read the file
      scanner.close();
  }
  ```

  En este ejemplo, el método `readFile()` declara que lanza una `FileNotFoundException`. Si el archivo especificado en el argumento `fileName` no existe, se lanzará una `FileNotFoundException` y el método llamante debe manejarla.

  Debes usar la palabra clave `throws` cuando un método puede potencialmente lanzar una excepción que no puede manejar por sí mismo. En estos casos, es responsabilidad del método llamante manejar la excepción. El uso de la palabra clave `throws` permite un manejo adecuado de errores y previene que el código se bloquee debido a excepciones no manejadas.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cuál es el propósito de usar "throw new" en Java y cuándo se debe usar?</summary>

  <!-- ✅ -->

  La palabra clave `throw new` en Java se usa para lanzar una excepción personalizada. El propósito de usar la palabra clave `throw new` es para levantar una excepción en el código y detener la ejecución del programa. Esto es útil en los casos en que el código encuentra una condición excepcional que no se puede manejar dentro del método y requiere que el método llamante maneje la excepción.

  Aquí hay un ejemplo de cómo se puede usar la palabra clave `throw new` en un método:

  ```java
  public void divide(int a, int b) throws ArithmeticException {
      if (b == 0) {
          throw new ArithmeticException("Cannot divide by zero");
      }
      int result = a / b;
      System.out.println("Result: " + result);
  }
  ```

  En este ejemplo, el método `divide()` verifica si el denominador "b" es igual a cero. Si es así, el método lanza una excepción personalizada `ArithmeticException` con un mensaje que indica que la división entre cero no está permitida. El método llamante debe manejar la excepción o declarar que también lanza la misma excepción.

  Deberías usar la palabra clave `throw new` cuando encuentres una condición excepcional en tu código que no se pueda manejar dentro del método. Esto permite que el método llamante maneje la excepción y evite que el programa se bloquee debido a excepciones no manejadas.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cómo puedo usar las clases "File" y "FileWriter" en Java para escribir en un archivo?</summary>

  <!-- ✅ -->

  Para escribir en un archivo en Java, puedes usar las clases `File` y `FileWriter`. La clase `File` se usa para crear un archivo o directorio en el sistema de archivos, mientras que la clase `FileWriter` se usa para escribir caracteres en el archivo.

  Aquí hay un ejemplo de cómo puedes usar estas clases para escribir en un archivo:

  ```java
  import java.io.File;
  import java.io.FileWriter;
  import java.io.IOException;

  public class FileExample {
      public static void main(String[] args) {
          try {
              // Create a new file object
              File file = new File("example.txt");

              // Create a new FileWriter object to write to the file
              FileWriter writer = new FileWriter(file);

              // Write some text to the file
              writer.write("This is an example of writing to a file in Java.");

              // Close the writer to save the changes
              writer.close();

              System.out.println("File written successfully");
          } catch (IOException e) {
              System.out.println("An error occurred while writing to the file: " + e.getMessage());
          }
      }
  }
  ```

  En este ejemplo, se crea un nuevo objeto `File` con el nombre `example.txt`. Luego se crea un objeto `FileWriter`, pasando el objeto `File` como parámetro. El método `write()` se usa para escribir el texto en el archivo y se llama al método `close()` para guardar los cambios.

  Ten en cuenta que al usar `FileWriter`, el archivo se crea si aún no existe y cualquier contenido existente en el archivo se sobrescribe. Si deseas agregar en lugar de sobrescribir a un archivo existente, puedes usar el constructor de `FileWriter` que toma dos parámetros, el segundo siendo un `boolean` que indica si se agrega o no al archivo.

  ```java
  FileWriter writer = new FileWriter(file, true);
  ```

  Es importante atrapar cualquier `IOException` que pueda ser lanzada al escribir en un archivo, ya que esto indica que ocurrió un error al realizar la operación. En este ejemplo, se imprime el mensaje de error en la consola.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cuál es el uso de "assertThrows" en JUnit y cómo puedo usarlo para probar excepciones en Java?</summary>

  <!-- ✅ -->

  El método `assertThrows` en JUnit se utiliza para probar si una determinada excepción es lanzada por una pieza específica de código. Te permite asegurarte de que tu código se comporta correctamente cuando ocurre una excepción.

  Aquí hay un ejemplo de cómo puedes usar `assertThrows` en JUnit:

  ```java
  @Test
  public void testException() {
      Exception exception = assertThrows(IllegalArgumentException.class, () -> {
          // Code that should throw the exception
      });
      assertEquals("Exception message", exception.getMessage());
  }
  ```

  En el ejemplo anterior, estamos probando si el código dentro de la expresión lambda lanza una excepción `IllegalArgumentException`. Si el código lanza la excepción, será capturada y almacenada en la variable `exception`. Luego, podemos usar `assertEquals` para verificar que el mensaje de excepción sea correcto.

  **Nota**: El método `assertThrows` está disponible en JUnit 5 y versiones posteriores.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">No puedo enviar cambios a mi repositorio. ¿Qué debo hacer?</summary>

  <!-- ✅ -->

  Si no puedes enviar cambios a tu repositorio, aquí hay algunos pasos que puedes seguir:

  1. Verifica tu conexión a internet: Asegúrate de que tu conexión a internet sea estable y funcione.
  2. Verifica la URL de tu repositorio: Asegúrate de estar usando la URL correcta de tu repositorio para enviar tus cambios.
  3. Revisa tus credenciales de Git: Asegúrate de que tus credenciales de Git estén actualizadas y correctas. Puedes revisar tus credenciales usando el siguiente comando:

  ```bash
  git config --list
  ```

  4. Actualiza tu repositorio local: Antes de enviar cambios, asegúrate de que tu repositorio local esté actualizado con el repositorio remoto. Puedes actualizar tu repositorio local usando el siguiente comando:

  ```bash
  git fetch origin
  ```

  5. Revisa posibles conflictos: Si hay conflictos entre tu repositorio local y el repositorio remoto, resuélvelos antes de enviar cambios.
  6. Envía cambios: Una vez que hayas resuelto los conflictos y actualizado tu repositorio local, puedes intentar enviar cambios nuevamente usando el siguiente comando:

  ```bash
  git push origin <branch_name>
  ```

</details>