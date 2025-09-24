# Implementaci-n-de-un-monitor-de-composta-inteligente-con-ESP32-CAM
Este proyecto implementa una máquina de estados para un sistema de monitoreo de composta. Se incluye: Lectura de sensores de humedad, temperatura y gas metano. Almacenamiento de un historial de datos en formato CSV en una tarjeta SD. Creación de un servidor web para visualizar. Proporciona opciones para descargar y borrar el historial desde la web.

Se creo una app para mejorar el uso de usuario FlowControl

# 🌱 Monitor Inteligente para Composta

¡Bienvenido al proyecto de Monitoreo Inteligente para Composta! Este sistema utiliza sensores para vigilar la salud de tu composta y asegurarse de que los desechos orgánicos se conviertan en abono rico en nutrientes de la manera más eficiente posible.

### 💧 **1. Humedad**

* **Rango ideal: 40% - 60%**
* **¿Qué pasa si está muy seca?** Los microorganismos que hacen el trabajo duro se mueren de sed y el proceso se detiene.
* **¿Qué pasa si está muy mojada?** El agua desplaza el oxígeno, los microorganismos se "ahogan" y la composta empieza a oler mal por la descomposición anaeróbica (sin aire).

### 🔥 **2. Temperatura**
Una composta caliente es una composta que está trabajando. La temperatura es la mejor señal de que millones de microorganismos están descomponiendo activamente los residuos.

* **Rango óptimo: 35°C - 55°C**
* **Fase de higienización:** Al principio, es normal que la temperatura suba hasta los **60-70°C**. Este calor intenso elimina patógenos, plagas y semillas de malas hierbas.

### 🌬️ **3. Oxígeno**
Como cualquier ser vivo, los microorganismos de tu composta necesitan oxígeno. Medimos esto de forma indirecta vigilando el **Gas Metano (CH₄)**.

* **Nivel ideal de Metano: Idealmente por debajo de las 1000 ppm, lo más cercano a 0 ppm (Partes por Millón) posible.**
* **¿Qué significa un nivel alto de metano?** Es una señal de alerta 🚨. Significa que no hay suficiente oxígeno y la composta se está "asfixiando".
* **La solución:** Si detectamos metano, es hora de **voltear la composta** para que se airee.

## ¿Cómo Entendemos a los Sensores?

Los sensores nos dan datos en bruto, como números sin un significado claro. Nuestro código actúa convirtiendo esos números en información útil y fácil de entender.

* **Sensor de Humedad (FC-28):** Traducimos sus lecturas a un sencillo **porcentaje de humedad**, de 0% (totalmente seco) a 100% (empapado).
* **Sensor de Temperatura (DS18B20):** Este es fácil. Nos da la temperatura directamente en los **grados Celsius (°C)** que todos conocemos.
* **Sensor de Gas Metano (MQ-4):** Convertimos su señal en **Partes por Millón (ppm)** para saber con precisión si a nuestra composta le falta aire.

  ## Estados de funcionamiento
* **1 minuto en cada encendido para mejorar las lecturas del MQ-4 (estabilidad)** (led encendido)
* **2 minutos en modo lectura** (led encendido)
* **3 minutos en modo servidor** (led apagado)
* **5 minutos en modo reposo** (led parpadeando)
