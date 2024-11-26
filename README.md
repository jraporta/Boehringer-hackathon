## 📄Descripción del reto

El Dr. Carlos, un dermatólogo apasionado, se encuentra ante un misterio médico: sus pacientes presentan síntomas desconcertantes que sugieren una enfermedad rara y compleja, la **Psoriasis Pustulosa Generalizada (PPG)**. Esta enfermedad autoinmune crónica causa pústulas dolorosas en la piel y puede afectar significativamente la calidad de vida de los pacientes. El camino hacia el diagnóstico es intrincado, y cada paso en falso puede retrasar el tratamiento crucial.

**El Reto**: Crear una herramienta digital que guíe al Dr. Carlos en el diagnóstico de la PPG. Esta herramienta debería permitirle recopilar datos de pacientes de manera eficiente, acceder a información actualizada sobre PPG y aprovechar algoritmos inteligentes para orientar su diagnóstico. Con esta herramienta, el Dr. Carlos podrá navegar por el complejo mundo de la PPG con mayor confianza, brindando a sus pacientes el diagnóstico preciso y oportuno que necesitan para recibir el tratamiento adecuado y mejorar su calidad de vida.

## 📋Descripción

Aplicación Web que facilita el trabajo de diagnóstico de la PPG a los dermatólogos. Permite llevar un seguimiento de los pacientes y registrar sus síntomas. Las herramientas de Inteligencia Artificial realizan un diagnóstico basándose en los síntomas así como recomendaciones de como debe ser el tratamiento a seguir por parte del paciente.

## 💻Tecnologías

- Spring Boot
- Java 21
- Maven
- PostgreSQL
- Postman
- Docker

## 🌐Despliegue

Desplegado con Render. Accesible en <https://ppgdiagnose-latestv2.onrender.com/>.

## 🚩Listado de Endpoints


### **Pacientes**
1. **Obtener un paciente por ID**
    - **Método:** `GET`
    - **URL:** `{{url}}/api/patients/1`
    - **Descripción:** Recupera información del paciente con ID `1`.

2. **Eliminar un paciente por ID**
    - **Método:** `DELETE`
    - **URL:** `{{url}}/api/patients/5`
    - **Descripción:** Elimina el paciente con ID `5`.

3. **Obtener todos los pacientes**
    - **Método:** `GET`
    - **URL:** `{{url}}/api/patients`
    - **Descripción:** Recupera información de todos los pacientes.

4. **Agregar un nuevo paciente**
    - **Método:** `POST`
    - **URL:** `{{url}}/api/patients`
    - **Cuerpo de la solicitud:**
      ```json
      {
          "name": "Mary Holmes",
          "age": 47,
          "gender": "female"
      }
      ```  
    - **Descripción:** Crea un nuevo paciente con los datos proporcionados.

5. **Actualizar datos de un paciente**
    - **Método:** `PUT`
    - **URL:** `{{url}}/api/patients`
    - **Cuerpo de la solicitud:**
      ```json
      {
          "id": 6,
          "age": 43
      }
      ```  
    - **Descripción:** Actualiza los datos proporcionados del paciente con ID `6`.

---

### **Síntomas**
1. **Obtener un síntoma por ID**
    - **Método:** `GET`
    - **URL:** `{{url}}/api/symptoms/1`
    - **Descripción:** Recupera información del síntoma con ID `1`.

2. **Obtener todos los síntomas**
    - **Método:** `GET`
    - **URL:** `{{url}}/api/symptoms`
    - **Descripción:** Recupera información de todos los síntomas.

3. **Agregar un nuevo síntoma**
    - **Método:** `POST`
    - **URL:** `{{url}}/api/symptoms`
    - **Descripción:** Crea un nuevo síntoma.
    - **Cuerpo de la solicitud:**
      ```json
      {"name": "picazón"}
      ```

4. **Importar múltiples síntomas**
    - **Método:** `POST`
    - **URL:** `{{url}}/api/symptoms/import`
    - **Cuerpo de la solicitud:**
      ```json
      [
          {"name": "picazón"},
          {"name": "rojez"},
          {"name": "escamación"},
          {"name": "dolor"},
          {"name": "supuración"}
      ]
      ```  
    - **Descripción:** Importa una lista de nuevos síntomas.

---

### **Informe médico**
1. **Obtener un informe médico por ID**
    - **Método:** `GET`
    - **URL:** `{{url}}/api/medicalreports/1`
    - **Descripción:** Recupera información del informe médico con ID `1`.

2. **Obtener todos los informes médicos de un paciente**
    - **Método:** `GET`
    - **URL:** `{{url}}/api/patients/1/medicalreports`
    - **Descripción:** Recupera todos los informes médicos del paciente con ID `1`.

3. **Agregar un nuevo informe médico**
    - **Método:** `POST`
    - **URL:** `{{url}}/api/patients/1/medicalreports`
    - **Cuerpo de la solicitud:**
      ```json
      {
          "doctorNotes": "Presenta una leve mejoría desde la última visita.",
          "symptoms": [
              {"id": "2"},
              {"id": "3"}
          ]
      }
      ```  
    - **Descripción:** Crea un nuevo informe médico para el paciente con ID `1`.

---

### **Diagnóstico**
1. **Obtener un diagnóstico generado por IA para un paciente**
    - **Método:** `GET`
    - **URL:** `{{url}}/api/patients/2/iadiagnose`
    - **Descripción:** Obtiene un diagnóstico generado por IA para el paciente con ID `2`.

